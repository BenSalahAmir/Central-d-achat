package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.Post;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CategoryProductDto implements Serializable {
    private final String nameCategoryProduct;
    private final List<Post> posts;
}