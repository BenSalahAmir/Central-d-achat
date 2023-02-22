package tn.esprit.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
