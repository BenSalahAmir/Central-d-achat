package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.CategoryProduct;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Entity.User;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ProductDto implements Serializable {
    private final String descriptionProduct;
    private final float priceProduct;
    private final Long quantityProduct;
    private final String nameProduct;
    private final String referenceProduct;
    private final String imageProduct;
    private final float discountProduct;
    private final String marqueProduct;
    private final Date dateCreationProduct;
    private final CategoryProduct categoryProduct;
    private final User userProduct;
    private final CommentPost comment;
}