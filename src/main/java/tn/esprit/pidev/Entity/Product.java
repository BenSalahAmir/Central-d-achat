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

    @OneToMany(mappedBy = "product")
    private List<RatingProduct> ratingProductList;


    @ManyToMany(mappedBy = "productListOrder")
    private List<User> usersOrder;

    @ManyToMany(mappedBy = "productListCart")
    private List<User> usersCart;


    @ManyToOne
    private User userProduct;

    @OneToOne
    private CommentPost comment;


}
