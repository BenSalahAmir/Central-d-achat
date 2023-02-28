package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CommentPostDto implements Serializable {
    private final Date dateCreationComment;
    private final String descriptionComment;
    private final Long nbLiked;
    private final Long nbDisliked;
    private final Post post;
    private final User userComment;
    private final Product productForum;
    private final List<LikeComment> likeComments;
    private final List<DislikeComment> dislikeComments;
}