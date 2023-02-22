package tn.esprit.pidev.Entity;

import lombok.*;

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
        private List<Product>productList;

        @OneToMany(mappedBy = "categoryPost")
        private List<Post>posts;
}
