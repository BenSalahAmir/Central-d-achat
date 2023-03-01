package tn.esprit.claimfacturesservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.claimfacturesservice.Entities.Facture;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
   Facture findByReference(String refence);
   //String findByCartDelivery_StatusDelivery();
List<Facture> findByArchiveFalseAndDatefacture(LocalDate datefact);


   List<Facture> findByArchiveFalse();
}
