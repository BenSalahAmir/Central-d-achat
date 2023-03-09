package tn.esprit.ms_gestionlivraison.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ToString
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProduct;
    private String descriptionProduct;
    private float priceProduct;
    private Long quantityProduct;
    private String nameProduct;
    private String referenceProduct;
    private String imageProduct;
    private float discountProduct;
    private String marqueProduct;
    @Temporal(TemporalType.DATE)
    private Date dateCreationProduct;

    @ManyToOne
    private CategoryProduct categoryProduct;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<RatingProduct> ratingProductList;


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CartLine> cartLines;

    @ManyToOne
    private User userProduct;

    @OneToOne
    private CommentPost comment;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    /*@JoinTable(
            name = "FavorisProduct",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idFavori"))*/
    private List<FavoriProduct> favoriProducts;

    @ManyToOne
    private Sous_CategoryProduct sousCategorie;


}
