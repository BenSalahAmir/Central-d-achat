package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orderc implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idOrder;
    private StatusOrder statusOrder;
    private float totalOrderPrice;
    private String codeDiscount;


    @ManyToOne
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product productOrder;

    @OneToOne
    private Facture facture;

}

