package tn.esprit.claimfacturesservice.Service;

import tn.esprit.claimfacturesservice.Entities.Claim;
import tn.esprit.claimfacturesservice.Entities.FactureAvoir;

import java.util.List;

public interface FacturAvoirService {


    public FactureAvoir addFactureAvoir(FactureAvoir factureAvoir);
    public FactureAvoir UpdateFactureAvoir(FactureAvoir factureAvoir);
    public Boolean DeleteFactureAvoir(Long id);
    public FactureAvoir retrieveFactureAvoirById(Long id);
    public List<FactureAvoir> retrieveAllFactureAvoir();
}
