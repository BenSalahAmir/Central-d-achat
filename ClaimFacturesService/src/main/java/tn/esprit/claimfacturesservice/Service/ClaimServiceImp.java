package tn.esprit.claimfacturesservice.Service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.claimfacturesservice.Entities.*;
import tn.esprit.claimfacturesservice.Repository.*;
import tn.esprit.claimfacturesservice.dtoEntities.MailRequest;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Slf4j
public class ClaimServiceImp implements ClaimService {
    @Autowired
    ClaimRepo claimRepo;
    @Autowired
    ProductRepository productRepo;

    @Autowired
    CartLineRepository cartLineRepository;
    @Autowired
    UserRepository userRepo;
    @Autowired
    FactureRepository factureRepo;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    EmailService emailService;


    @Override
    public Claim addClaim(Claim claim) {
        claim.setDateCreationClaim(new Date());
        claim.setStatusClaim(StatusClaim.NONTRAITE);
        return claimRepo.save(claim);
    }

    @Override
    public Claim UpdateClaim(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public Boolean DeleteClaim(Long id) {
        if (claimRepo.existsById(id)) {
            claimRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
     public Claim retrieveclaimById(Long id) {
        return claimRepo.findById(id).orElse(null);
    }

    @Override
    public List<Claim> retrieveAllclaim() {
        return claimRepo.findAll();
    }

    @Override
    public Claim UpdateClaimStatut(Long idClaim, StatusClaim newStatut) {
        Claim claim = claimRepo.findById(idClaim).orElse(null);
        claim.setStatusClaim(newStatut);
        return claimRepo.save(claim);
    }

    @Override
    public boolean isOwner(long idclaim) {
        User user = claimRepo.findById(idclaim).get().getUserclaim();
        Facture facture = claimRepo.findById(idclaim).get().getFacture();
        if(user!=null && facture!=null) {
            if (user.getIdUser() == facture.getUser().getIdUser()) {
                return true;
            }
            return false;
   }return false ;
    }
    public String isPurchase(String refProduct, Long idUser) {
        User user = userRepo.findById(idUser).orElse(null);
        List<Facture> factures = user.getFactureList();
        Product productRef = productRepo.findByReferenceProduct(refProduct);
        if (productRef != null) {
            for (Facture facture : factures) {
                List<Delivery> deliveries = new ArrayList<>();
                deliveries.add(facture.getDelivery());
                for (Delivery delivery : deliveries) {
                    List<Cart> carts = new ArrayList<>();
                    carts.add(delivery.getCart());
                    for (Cart cart : carts) {
                        List<CartLine> cartLines = new ArrayList<>();
                        cartLines.addAll(cart.getCartLines());
                        for (CartLine cartLine : cartLines) {
                            List<Product> products = new ArrayList<>();
                            products.add(cartLine.getProduct());
                            for (Product product : products) {
                                if (product.getReferenceProduct() == refProduct) {
                                    return ("this product" + product.getNameProduct() + " has been purchased by the user " + user.getFirstName() + user.getLastName());
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    public Boolean DateValideClaim(Long Idclaim, Long Iddelivery) {
        Delivery delivery= deliveryRepository.findById(Iddelivery).orElse(null);
        Claim claim = claimRepo.findById(Idclaim).orElse(null);
        Date deliveryDate = delivery.getDeliverytime();
        Date claimDate = claim.getDateCreationClaim();
        Long diff = claimDate.getTime() - deliveryDate.getTime();
        float res = (diff / (1000 * 60 * 60 * 24));
      if(delivery != null && claim!=null ){
        if (res >= 3 && (claimDate.after(deliveryDate))) {
              //return (true +""+ res);
            String to = "<eyazidi2640@gmail.com>";
            String from = "<zidieya29310@gmail.com>";
            String subject = "Claim not valid";
            String message = "Your claim with ID " + Idclaim + " is not valid. Please contact us for more information.";
            Map<String, Object> model = new HashMap<>();
            model.put("message", message);
            MailRequest request = new MailRequest();
            request.setTo(to);
            request.setFrom(from);
            request.setSubject(subject);
            emailService.sendEmail(request, model);

            return false;
        }
       return true;
      }
        // return ("false" + ""+ res);
        return false;
    }

    @Override
    public void isClaimValid(Long claimId, String invoiceNumber) {
        Claim claim = claimRepo.findById(claimId).orElse(null);
        Facture facture = factureRepo.findByReference(invoiceNumber);
        DeliveryMen men = factureRepo.findByReference(invoiceNumber).getDelivery().getDeliveryMen();

        // if (facture != null && facture.getClaims().equals(claim)) {
        if (claim.getCategoryClaim().equals(CategoryClaim.PRODUCTCLAIM)) {

            if (DateValideClaim(claimId, facture.getDelivery().getId_Delivery()) && isOwner(claimId)) {
                claimRepo.save(claim);
            }
        } else if (claim.getCategoryClaim().equals(CategoryClaim.DELIVERYCLAIM)) {
            claim.setDeliveryMen(men);
            claimRepo.save(claim);
        }

        else if (claim.getCategoryClaim().equals(CategoryClaim.SERVICECLAIM))
            claimRepo.save(claim);

        else claimRepo.delete(claim);
    }

    @Override
    @Transactional
    public void banUser(Long supplierId) {
        User user=userRepo.findById(supplierId).orElse(null);
        List<Claim> claims  = user.getClaimList();
        System.out.println("user claim "+user.getClaimList());
        List<CartLine> cartLines=cartLineRepository.getss(supplierId);

        int nbcart= cartLines.size();
        int nbclaims =claims.size();
       if(nbcart> 0){
         if (nbclaims >= (nbcart*20)/100){
             int nba= user.getNbrAvertissment();
             if (nba <3){
                 //mail tanbih
                    nba++;
                    user.setNbrAvertissment(nba);
                    userRepo.save(user);

                 log.info("user claimed");
             }else {
                 user.setBanned(true);
                 userRepo.save(user);

                 log.info("User Banned");
             }

          }
       }
    }


//naml sch n geti les fnct w n9olou kol claim chnou hkeyetha


}

















