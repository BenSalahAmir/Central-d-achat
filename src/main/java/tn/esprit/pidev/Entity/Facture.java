package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFacture;
    private String topicFacture;
    private boolean archive;
    private String reference;
    private String priceTotal;

    @OneToOne(mappedBy = "facture")
    private Orderc orderc;

    @OneToOne
    private FactureAvoir factureAvoir;


}
