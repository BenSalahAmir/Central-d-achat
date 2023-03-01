package tn.esprit.claimfacturesservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.claimfacturesservice.Entities.Claim;
import tn.esprit.claimfacturesservice.Entities.Delivery;
import tn.esprit.claimfacturesservice.Entities.StatusClaim;
import tn.esprit.claimfacturesservice.Service.ClaimService;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/claimFacture/claim")
public class ClaimController {
@Autowired
    ClaimService claimService;

    @GetMapping("/hello")
    public String hello(){
        return ("hello claimFacture");
    }
    @PostMapping()
    public Claim addClaim(@RequestBody Claim claim) {
        return claimService.addClaim(claim);
    }


    @PutMapping()
    public Claim UpdateClaim(@RequestBody Claim claim) {
        return	claimService.UpdateClaim(claim);
    }


    @PutMapping("/{id}/{newStatut}")
    public Claim UpdateClaimStatut(@PathVariable Long id,@PathVariable StatusClaim newStatut) {
        return	claimService.UpdateClaimStatut(id,newStatut);
    }

@GetMapping("/{claim}/{delivery}")
public boolean kaka(@PathVariable Claim claim , @PathVariable Delivery delivery){
        return claimService.DateValideClaim( claim ,  delivery);
}
    @GetMapping("/{id}")
    public Claim retrieveclaimById(@PathVariable Long id ) {
        return	claimService.retrieveclaimById(id);
    }

    @GetMapping()
    public List<Claim> retrieveAllclaim() {
        return	claimService.retrieveAllclaim();
    }

    @DeleteMapping("/{id}")
    public Boolean DeleteClaim(@PathVariable Long id) {
        return	claimService.DeleteClaim(id);
    }

  // @PostMapping("/{claimId}/{invoiceNumber}")
 //  public void isClaimValid (@PathVariable Long claimId ,@PathVariable String invoiceNumber)  {
  //     claimService.isClaimValid(claimId,invoiceNumber);
  // }

//    @PostMapping("/sendemail")
//    public void sendEmail(@RequestBody String from ,@RequestBody String to, @RequestBody String subject, @RequestBody String text) {
//
//        claimService.sendSimpleMessage(from,to, subject, text);
//        ResponseEntity.ok("Request processed successfully");
//
//    }



//    @PostMapping("/create")
//    public void createClaim(@RequestBody Long id) {
//        claimService.createClaim(id);
//    }



}
