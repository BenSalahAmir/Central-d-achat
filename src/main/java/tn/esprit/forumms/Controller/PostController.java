package tn.esprit.forumms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forumms.Entity.Post;
import tn.esprit.forumms.Service.IPostService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/forum/post")
public class PostController{
    public final IPostService iPostService;

    @PostMapping("add/{idUser}/{idCategory}")
    public Post addPost(@RequestBody Post p,@PathVariable Long idUser,@PathVariable Long idCategory){
        return iPostService.addPost(p,idUser, idCategory);
    }
    @GetMapping("getall")
    public List<Post> getAllPosts(){
        return iPostService.getAllPosts();
    }

    @DeleteMapping("delete/{idPost}/{idUser}")
    public void deletePost(@PathVariable Long idPost,@PathVariable Long idUser){
        iPostService.deletePost(idPost, idUser);
    }

    @GetMapping("getById/{idPost}")
    public Post getById(@PathVariable Long idPost){
        return iPostService.getById(idPost);
    }

    @PutMapping("edit/{idUser}")
    public Post editPost(@RequestBody Post p,@PathVariable Long idUser){
        return iPostService.editPost(p,idUser);
    }

}
