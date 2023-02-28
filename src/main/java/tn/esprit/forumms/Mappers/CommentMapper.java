package tn.esprit.forumms.Mappers;


import tn.esprit.forumms.DTOentities.CommentPostDto;
import tn.esprit.forumms.Entity.CommentPost;
public class CommentMapper {
    public static CommentPostDto mapToDto(CommentPost commentPost){
        CommentPostDto commentPostDto = CommentPostDto.builder()
                .dateCreationComment(commentPost.getDateCreationComment())
                .descriptionComment(commentPost.getDescriptionComment())
                .post(commentPost.getPost())
                .userComment(commentPost.getUserComment())
                .nbLiked(commentPost.getNbLiked())
                .productForum(commentPost.getProductForum())
                .nbDisliked(commentPost.getNbDisliked())
                .likeComments(commentPost.getLikeComments())
                .dislikeComments(commentPost.getDislikeComments())
                .build();
        return commentPostDto;
    }
    public static CommentPost mapToEntity(CommentPostDto commentPostDto){
        CommentPost commentPost = CommentPost.builder()
                .dateCreationComment(commentPostDto.getDateCreationComment())
                .descriptionComment(commentPostDto.getDescriptionComment())
                .post(commentPostDto.getPost())
                .userComment(commentPostDto.getUserComment())
                .nbLiked(commentPostDto.getNbLiked())
                .productForum(commentPostDto.getProductForum())
                .nbDisliked(commentPostDto.getNbDisliked())
                .likeComments(commentPostDto.getLikeComments())
                .dislikeComments(commentPostDto.getDislikeComments())
                .build();
        return commentPost;
    }
}
