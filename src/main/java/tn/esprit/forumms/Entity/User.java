package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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


    @JsonIgnore
    //@Transient
    @ManyToMany
    @JoinTable(
            name = "Orderc",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idProduct"))
    private List <Product> productListOrder;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "Cart",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idProduct"))
    private List <Product> productListCart;

    @JsonIgnore
    @OneToMany(mappedBy = "userPost")
    private List<Post>posts;

    @JsonIgnore
    @OneToMany(mappedBy = "userComment")
    List<CommentPost>commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "userProduct")
    private List<Product> productListUser;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<LikeComment> likeComments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<DislikeComment> dislikeComments;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role>roles =new ArrayList<>();


}
