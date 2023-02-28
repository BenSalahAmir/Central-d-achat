package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder

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

    @JsonIgnore
    @ManyToOne
    private CategoryProduct categoryProduct;

    @JsonIgnore
    @ManyToMany(mappedBy = "productListOrder")
    private List<User> usersOrder;

    @JsonIgnore
    @ManyToMany(mappedBy = "productListCart")
    private List<User> usersCart;

    @JsonIgnore
    @ManyToOne
    private User userProduct;

    @JsonIgnore
    @OneToOne
    private CommentPost comment;


}
