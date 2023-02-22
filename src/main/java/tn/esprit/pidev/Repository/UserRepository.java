package tn.esprit.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.Entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);

}
