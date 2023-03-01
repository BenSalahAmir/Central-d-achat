package tn.esprit.claimfacturesservice.Service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.claimfacturesservice.Entities.*;
import tn.esprit.claimfacturesservice.Repository.ClaimRepo;
import tn.esprit.claimfacturesservice.Repository.FactureRepository;
import tn.esprit.claimfacturesservice.Repository.ProductRepository;
import tn.esprit.claimfacturesservice.Repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class ClaimServiceImp implements ClaimService {
    @Autowired
    ClaimRepo claimRepo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    FactureRepository factureRepo;


    @Override
    public Claim addClaim(Claim claim) {

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


    public Boolean DateValideClaim(Claim claim, Delivery delivery) {
        Date deliveryDate = delivery.getDeliverytime();
        Date claimDate = claim.getDateCreationClaim();

        Long diff = claimDate.getTime() - deliveryDate.getTime();
        float res = (diff / (1000 * 60 * 60 * 24));
        if (res >= 3 && (claimDate.after(deliveryDate))) {
            //  return ("true" +""+ res);
            return true;
        }
        // return ("false" + ""+ res);
        return false;
    }

    public boolean isOwner(Claim claim) {
        User user = claim.getUserclaim();
        Facture facture = claim.getFacture();
        if (user.getIdUser() != facture.getUser().getIdUser()) {
            return true;
        }
        return false;
    }

    public void isClaimValid(Long claimId, String invoiceNumber) {
        Claim claim = claimRepo.findById(claimId).orElse(null);
        Facture facture = factureRepo.findByReference(invoiceNumber);

        if (claim.getCategoryClaim().equals(CategoryClaim.PRODUCTCLAIM)) {
            if (facture != null && facture.getClaims().equals(claim)) {
                // Invoice number exists and is associated with the claim

                claimRepo.save(claim);
            } else if (claim.getCategoryClaim().equals(CategoryClaim.DELIVERYCLAIM)) {
//          int nbrclaim = claimRepo.findAll(); nheb nejbed ll claim bel iduser eli role mte3hom  deleverymen namllhom count
            }
            {
                // Invoice number doesn't exist or is not associated with the claim
                claimRepo.delete(claim);
            }
        } else if (claim.getCategoryClaim().equals(CategoryClaim.DELIVERYCLAIM)) {


        }

    }

     public void banUser(Long supplierId) {
//Score
//200 hekom lezm ywaliw bel pourcentage par rapport leli be3ou
//fichier excel fih les mot + et fichier excel fih les mot -
// w nchoufou ywali feedback + wala feedback -
//
//        User user = userRepo.findById(supplierId).orElse(null);
//        Claim claim = new Claim();
//        claim.setUser(user);
//        claimRepo.save(claim);
//            List<Claim> claims = claimRepo.findByUser(user);
        //     if (claims.size() >= 200 ) {
        //  userRepo.blockUser(user);
//user.setBan();
//            sendEmail(user.getEmail());
//        }
//    }

    }


    private Claim MotInterdit(@PathVariable("id") Long id) {
        List<String> interdit = Arrays.asList("mot1", "mot2", "mot3");

        Claim reclamation = claimRepo.findById(id).orElse(null);
        String Text = reclamation.getDescriptionClaim();
        for (String motInterdit : interdit) {
            String ss = Text.replaceAll("mot3", "***");
            reclamation.setDescriptionClaim(ss);
        }
        return reclamation;
    }




    @Override

        public boolean isFraudulentComplaint(Claim claim) {
        //if (isDuplicate(claim,ref)) {
//             return true;
//            }
//            if (isPurchase(claim)) {
//                return true;
//            }
 //           if (isOwner(claim)) {
  //             return claimRepo.save(claim);
  //          } return claimRepo.delete(claim.getIdClaim());
           return false;
       }

}

















