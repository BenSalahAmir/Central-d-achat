package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idClaim;
    private String descriptionClaim;
    @Temporal(TemporalType.DATE)
    private Date dateCreationClaim;
    @Enumerated(EnumType.STRING)
    private CategoryClaim categoryClaim;
    @Enumerated(EnumType.STRING)
    private StatusClaim statusClaim;
    @Enumerated(EnumType.STRING)
    private TypeClaim typeClaim;


    @JsonIgnore
    @ManyToOne
    private User userclaim;

    @JsonIgnore
    @ManyToOne
    private Facture facture;

    @ManyToOne()
private  DeliveryMen deliveryMen;
}