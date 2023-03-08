package tn.esprit.claimfacturesservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.claimfacturesservice.Entities.FactureAvoir;
import tn.esprit.claimfacturesservice.Service.FacturAvoirService;
import tn.esprit.claimfacturesservice.dtoEntities.FactureAvoirDto;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/claimFacture/FactureAvoir")
public class FactureAvoirController {

    @Autowired
    FacturAvoirService FacturAvoirService;
    @PostMapping()
    public FactureAvoir factureAvoir(@RequestBody FactureAvoir factureAvoir) {
        return FacturAvoirService.addFactureAvoir(factureAvoir);
    }

//    @PostMapping()
//    public FactureAvoirDto factureAvoir(@RequestBody FactureAvoirDto factureAvoirDto) {
//        return (FactureAvoirDto)FacturAvoirService.addFactureAvoir(factureAvoirDto);
//    }
    @PutMapping()
    public FactureAvoir UpdateFacture(@RequestBody FactureAvoir factureAvoir) {
        return	FacturAvoirService.UpdateFactureAvoir(factureAvoir);
    }
    @GetMapping("/{id}")
    public FactureAvoir retrieveFactureById(@PathVariable Long id ) {
        return	FacturAvoirService.retrieveFactureAvoirById(id);
    }

    @GetMapping()
    public List<FactureAvoir> retrieveAllFactureAvoir() {
        return	FacturAvoirService.retrieveAllFactureAvoir();
    }
    @DeleteMapping("/{id}")
    public Boolean DeleteFactureAvoir(@PathVariable Long id) {
        return	FacturAvoirService.DeleteFactureAvoir(id);
    }

}
