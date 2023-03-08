package tn.esprit.forumms.Service;


import org.springframework.web.multipart.MultipartFile;
import tn.esprit.forumms.Entity.Post;

import java.io.IOException;
import java.util.List;

public interface IPostService {

    public List<Post> getAllPosts();
    public Post addPost(Post post,Long idUser,Long idCategory, MultipartFile imageFile) throws IOException;
    public Post editPost(Post post,Long idUser);
    public void deletePost(Long postId,Long idUser);
    public Post getById(Long postId);

}
