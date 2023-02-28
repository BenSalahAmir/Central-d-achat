package tn.esprit.forumms.Service;


import tn.esprit.forumms.Entity.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getAllPosts();
    public Post addPost(Post post,Long idUser,Long idCategory);
    public Post editPost(Post post,Long idUser);
    public void deletePost(Long postId,Long idUser);
    public Post getById(Long postId);

}
