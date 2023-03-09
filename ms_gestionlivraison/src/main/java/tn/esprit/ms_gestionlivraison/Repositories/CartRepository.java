package tn.esprit.ms_gestionlivraison.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ms_gestionlivraison.Entities.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
   // List<Cart>findCartByIdCartAndCartStatus ( Long idCart);
}
