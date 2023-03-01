package tn.esprit.claimfacturesservice.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.claimfacturesservice.Entities.Devise;
import tn.esprit.claimfacturesservice.Entities.Facture;
import tn.esprit.claimfacturesservice.Entities.TauxDEchange;
import tn.esprit.claimfacturesservice.Repository.DeviseRepository;
import tn.esprit.claimfacturesservice.Repository.FactureRepository;
import tn.esprit.claimfacturesservice.Repository.TauxdechangeRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@Slf4j
public class FactureServiceImp implements FactureService {
    @Autowired
     FactureRepository factureRepo;
    @Autowired
    private DeviseRepository deviseRepository;
    @Autowired
    private TauxdechangeRepository tauxdechangeRepository;
   @Override
    public Facture addFacture(Facture facture) {
//        Double montantConverti = convertirMontant(facture.getDelivery().getDeliveryPrice(), " DNT", facture.getDevise());
//
//        facture.getDelivery().setDeliveryPrice(montantConverti);
        return factureRepo.save(facture);
    }
    public double convertirMontant(double montant, String deviseDestination) {
        TauxDEchange tauxDeChange = (TauxDEchange) tauxdechangeRepository.findByDeviseOrigineAndDeviseDestination("DNT", deviseDestination);
        if (tauxDeChange == null) {
            throw new IllegalArgumentException("Aucun taux de change n'a été trouvé pour la devise de destination spécifiée.");
        }
        return montant * tauxDeChange.getTaux();
    }

//    public Double convertirMontantd(Double montant, String deviseOrigine, String deviseDestination) {
//        Devise deviseOrigineObj = deviseRepository.findByCode(deviseOrigine);
//        Devise deviseDestinationObj = deviseRepository.findByCode(deviseDestination);
//
//        return montant * deviseOrigineObj.getTaux() / deviseDestinationObj.getTaux();
//    }
    @Override
    public Facture UpdateFacture(Facture facture) {
        return  factureRepo.save(facture);
    }

    @Override
    public Boolean DeleteFacture(Long id) {
        if (factureRepo.existsById(id)) {
            factureRepo.deleteById(id);
            return true;
        }
        else {return false;}
    }

    @Override
    public Facture retrieveFactureById(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepo.findAll();
    }

        @Scheduled(cron = "*/30 * * * * ?")
    @Override
    public void retrieveAndUpdateStatusFacture() {

        // Archive all expired contracts
        this.archiveExpiredFacture();

        factureRepo.findByArchiveFalse().stream()
                .filter(facture -> ChronoUnit.DAYS.between(LocalDate.now(),facture.getDatefacture()) < 30 )
                .forEach(facture ->
                        log.info(
                                "Contrat num: " +facture.getIdFacture() +
                                        " de l'etudiant " + facture.getUser().getFirstName() + facture.getUser().getLastName() +
                                        " expirera aprés 15 jour de cette date " + facture.getDatefacture() +
                                        " / "+ ChronoUnit.DAYS.between(LocalDate.now(),facture.getDatefacture())
                        )
                );
    }

    @Transactional
    @Override
    public void archiveExpiredFacture() {
        factureRepo.findByArchiveFalseAndDatefacture(LocalDate.now())
                .stream()
                .forEach(facture -> facture.setArchive(true));
    }


    public Double convertirMontant(Double montant, String deviseOrigine, String deviseDestination) {
        Devise deviseOrigineObj = deviseRepository.findByCode(deviseOrigine);
        Devise deviseDestinationObj = deviseRepository.findByCode(deviseDestination);

        return montant * deviseOrigineObj.getTaux() / deviseDestinationObj.getTaux();
    }


}

