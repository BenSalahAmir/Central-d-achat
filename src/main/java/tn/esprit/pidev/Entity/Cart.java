package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCart;
    private float totalCartPrice;
    private String topic;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product productCart;

}
