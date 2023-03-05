package tn.esprit.forumms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Service.ICommentPostService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/forum/comment")
public class CommentPostController {
    public final ICommentPostService iCommentPostService;

    @GetMapping("/hello")
    public String hello(){
        return ("hello Forum");
    }

    @GetMapping("/getall")
    public List<CommentPost> getall(){
        return iCommentPostService.getAllComments();
    }

    @PostMapping("add/{idUser}/{idPost}")
    public CommentPost addComment(@RequestBody CommentPost c, @PathVariable Long idUser,@PathVariable Long idPost){
        return iCommentPostService.addComment(c,idUser,idPost);
    }
    @GetMapping("getById/{idComment}")
    public CommentPost getCommById(@PathVariable Long idComment){
        return iCommentPostService.getById(idComment);
    }

    @DeleteMapping("delete/{idUser}/{idPost}")
    public void deleteComment(@PathVariable Long idUser,@PathVariable Long idComment){
         iCommentPostService.deleteComment(idComment,idUser);
    }

    @PutMapping("setProduct/{idComment}/{idProduct}")
    public CommentPost setProductToComment(@PathVariable Long idComment,@PathVariable Long idProduct){
        return iCommentPostService.setProductToComment(idComment,idProduct);
    }

}
