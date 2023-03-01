package tn.esprit.claimfacturesservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.claimfacturesservice.Entities.TauxDEchange;

public interface TauxdechangeRepository extends JpaRepository<TauxDEchange,Long> {
    TauxdechangeRepository findByDeviseOrigineAndDeviseDestination(String deviseOrigine, String deviseDestination);

}
