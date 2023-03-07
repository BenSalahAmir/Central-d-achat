package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String country;
    private String gouvernment;
    private boolean etat;
    private Long phone;
    private boolean disponibilite;
    private int age ;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    /*@JoinTable(
            name = "FavorisProduct",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idFavori"))*/
    private List<FavoriProduct> favoris ;

    @OneToMany(mappedBy = "userRating")
    private List<RatingProduct> ratingProductList;

    @OneToMany(mappedBy = "userProduct")
    private List<Product> productListUser;
/**/
    @OneToMany(mappedBy = "usedBy")
    private List<Discount> discounts ;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts ;

    /**/
    @JsonIgnore
    @OneToMany(mappedBy = "userPost",cascade = CascadeType.ALL)
    private List<Post>posts;
    @JsonIgnore
    @OneToMany(mappedBy = "userComment",cascade = CascadeType.ALL)
    List<CommentPost>commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<LikeComment> likeComments;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<DislikeComment> dislikeComments;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles =new ArrayList<>();

}
