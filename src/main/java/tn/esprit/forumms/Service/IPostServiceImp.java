package tn.esprit.forumms.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.forumms.Entity.CategoryProduct;
import tn.esprit.forumms.Entity.Post;
import tn.esprit.forumms.Entity.User;
import tn.esprit.forumms.Repository.CategoryProductRepository;
import tn.esprit.forumms.Repository.PostRepository;
import tn.esprit.forumms.Repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;




import java.util.List;

@Service
@AllArgsConstructor
public class IPostServiceImp implements IPostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryProductRepository categoryProductRepository;


    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public boolean areStringsSimilar(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split(" ")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> difference = new HashSet<>(set1);
        difference.addAll(set2);
        difference.removeAll(intersection);

        return ((double)intersection.size() / (double)difference.size()) >= 0.7;
    }
    @Override
    public Post addPost(Post post,Long idUser,Long idCategory) {

        List<Post> posts=postRepository.findAll();
        Post similarPost = null;
        for (Post post1:posts) {
            if (areStringsSimilar(post1.getDescriptionPost(),post.getDescriptionPost())){
                similarPost=post1;
            }
        }
        if (similarPost!=null) {
            return similarPost;
        }
        else {
        CategoryProduct categoryProduct=categoryProductRepository.findById(idCategory).orElse(null);
        User u= userRepository.findById(idUser).orElse(null);
        post.setUserPost(u);
        post.setCategoryPost(categoryProduct);

        return postRepository.save(post);
        }
    }


    @Override
    public Post editPost(Post post,Long idUser) {
        User user=userRepository.findById(idUser).orElse(null);
        if (post.getUserPost().equals(user))
        return postRepository.save(post);
        else
            return null;
    }

    @Override
    public void deletePost(Long postId,Long idUser) {
        User user=userRepository.findById(idUser).orElse(null);
        if (postRepository.findById(postId).orElse(null).getUserPost().equals(user))
        postRepository.deleteById(postId);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
}
