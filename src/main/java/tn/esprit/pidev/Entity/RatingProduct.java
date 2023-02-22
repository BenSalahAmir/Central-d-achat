package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingProduct implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRaitingProduct;
    private int nbrEtoilesProduct;
    private String reviewProduct;

    @ManyToOne
    private Product product ;


    @ManyToOne
    private User userRating;
}
