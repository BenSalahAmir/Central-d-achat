package tn.esprit.ms_gestionlivraison.Entities;

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
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long IdDiscount;

    private String discountCode;

    private Date expiryDate;

    @Column(nullable = false)
    private double amount;

    private boolean percentage;

    @Enumerated(EnumType.STRING)
    private DiscountStatus discountStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usedBy;

    @OneToOne
    private Cart cart;

}
