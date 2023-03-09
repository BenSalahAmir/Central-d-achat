package tn.esprit.ms_gestionlivraison.Entities;

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
public class CategoryProduct implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCategoryProduct;
    private String nameCategoryProduct;

    @OneToMany(mappedBy = "categoryProduct")
    private List<Product> productListCategory;

    @OneToMany(mappedBy = "categoryPost")
    private List<Post>posts;

    @OneToMany(mappedBy = "category")
    private List<Sous_CategoryProduct> sous_categoryProducts ;

}
