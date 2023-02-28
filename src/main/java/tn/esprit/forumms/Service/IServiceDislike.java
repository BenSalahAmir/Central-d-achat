package tn.esprit.forumms.Service;


import tn.esprit.forumms.Entity.DislikeComment;

public interface IServiceDislike {

    public DislikeComment addDislike(DislikeComment dislikeComment,Long idUser,Long idComment);
    public void deleteDislike(Long idDislike);

}
