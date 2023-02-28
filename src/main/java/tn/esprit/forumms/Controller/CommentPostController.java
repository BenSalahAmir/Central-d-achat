package tn.esprit.forumms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Service.ICommentPostService;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentPostController {
    public final ICommentPostService iCommentPostService;

    @PostMapping("add/{idUser}/{idPost}")
    public CommentPost addComment(@RequestBody CommentPost c, @PathVariable Long idUser,@PathVariable Long idPost){
        return iCommentPostService.addComment(c,idUser,idPost);
    }

   /* @GetMapping("frobid/{idComment}")
    public void checkForbiddenWords(@PathVariable Long idComment){
        iCommentPostService.checkForbiddenWords(idComment);
    }*/

}
