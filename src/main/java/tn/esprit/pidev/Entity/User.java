package tn.esprit.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    private String username;
    private String email;
    private String password;
    private String country;
    private String gouvernment;
    private Boolean banned;
    private Boolean etat;
    private Boolean verified;
    private int phone;
    private Boolean disponibilite;
    private String image;
    @Transient
    private String token;
    private LocalDateTime createdate;


    @Enumerated(EnumType.STRING)
    private ERole ERole;


    //@Transient
    @ManyToMany
    @JoinTable(
            name = "Orderc",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idProduct"))
    private List <Product> productListOrder;


    @ManyToMany
    @JoinTable(
            name = "Cart",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idProduct"))
    private List <Product> productListCart;


    @OneToMany(mappedBy = "userPost")
    private List<Post>posts;

     @OneToMany(mappedBy = "userComment")
     List<CommentPost>commentList;


    @OneToMany(mappedBy = "user")
    private List<Delivery>deliveryList;


    @OneToMany(mappedBy = "userclaim")
    private List<Claim> claimList;

    @OneToMany(mappedBy = "userRating")
    private List<RatingProduct> ratingProductList;


    @OneToMany(mappedBy = "userProduct")
    private List<Product> productListUser;

    //fetch=EAGER WIL BE LOAD THE LIST FROM ENTITE
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role>roles =new ArrayList<>();

    
}
