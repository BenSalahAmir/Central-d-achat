package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryProduct implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long idCategoryProduct;
        private String nameCategoryProduct;

        @JsonIgnore
        @OneToMany(mappedBy = "categoryProduct")
        private List<Product>productList;

        @JsonIgnore
        @OneToMany(mappedBy = "categoryPost")
        private List<Post>posts;
}
