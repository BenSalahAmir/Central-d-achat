package tn.esprit.forumms.Service;


import tn.esprit.forumms.Entity.CommentPost;

import java.util.List;

public interface ICommentPostService {
    public List<CommentPost> getAllComments();
   // public CommentPost addComment(CommentPost commentPost,Long idUser,Long idPost) ;
   //public CommentPost editComment(CommentPost commentPost);

    CommentPost editComment(CommentPost commentPost, String idUser, Long idPost);

    public void deleteComment(Long commentId, String idUser);

    CommentPost addComment(CommentPost commentPost, String idUser, Long idPost);

    public CommentPost getById(Long commentId);
    public CommentPost setProductToComment(Long commentId,Long idProduct);
    public List<CommentPost> getCommentsSortedByAverage(Long idPost);

}