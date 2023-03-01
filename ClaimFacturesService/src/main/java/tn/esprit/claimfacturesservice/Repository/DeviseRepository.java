package tn.esprit.claimfacturesservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.claimfacturesservice.Entities.Devise;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long> {
    Devise findByCode(String code) ;

}


