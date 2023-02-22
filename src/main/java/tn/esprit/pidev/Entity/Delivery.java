package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDelivery;
    private boolean completed;
    private float chargeDelivery;
    private float priceTotalDelivery;
    @Temporal(TemporalType.DATE)
    private Date dateDelivery;
    private int duration;
    private String gouvernorat;

    @OneToMany(mappedBy = "delivery")
    private List<Orderc> ordercs;

    @ManyToOne
    private User user;


}
