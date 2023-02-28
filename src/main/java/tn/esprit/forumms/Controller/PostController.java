package tn.esprit.forumms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Entity.Post;
import tn.esprit.forumms.Service.IPostService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController{
    public final IPostService iPostService;

    @PostMapping("add/{idUser}/{idCategory}")
    public Post addPost(@RequestBody Post p,@PathVariable Long idUser,@PathVariable Long idCategory){
        return iPostService.addPost(p,idUser, idCategory);
    }

    @GetMapping("getall")
    public List<Post> allposts(){
        return iPostService.getAllPosts();
    }
}
