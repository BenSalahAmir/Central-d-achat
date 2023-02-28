package tn.esprit.forumms.Service;


import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Entity.Post;

import java.util.List;

public interface ICommentPostService {
    public List<CommentPost> getAllComments();
    public CommentPost addComment(CommentPost commentPost,Long idUser,Long idPost) ;
    public CommentPost editComment(CommentPost commentPost,Long idUser);
    public void deleteComment(Long commentId,Long idUser);
    public CommentPost getById(Long commentId);

}
