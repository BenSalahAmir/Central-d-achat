package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.CategoryProduct;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Entity.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class PostDto implements Serializable {
    private final String topicPost;
    private final String descriptionPost;
    private final String imagePost;
    private final Date dateCreationPost;
    private final CategoryProduct categoryPost;
    private final List<CommentPost> commentList;
    private final User userPost;
}