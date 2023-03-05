package tn.esprit.forumms.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCart;
    private double totalCartPrice;
    private String topic;
    @Enumerated(EnumType.STRING)
    private CartStatus cartStatus;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "cartLine")
    private List<CartLine> cartLines;

    @OneToOne
    private Discount discount;

}
