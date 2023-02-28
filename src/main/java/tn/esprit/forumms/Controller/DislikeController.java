package tn.esprit.forumms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.forumms.Entity.DislikeComment;
import tn.esprit.forumms.Service.IServiceDislike;

@RestController
@AllArgsConstructor
@RequestMapping("/dislike")
public class DislikeController {

    public final IServiceDislike iServiceDislike;

    @PostMapping("/dislikeComment/{idUser}/{idComment}")
    public DislikeComment addDislike(@RequestBody DislikeComment dislikeComment, @PathVariable Long idUser,@PathVariable Long idComment){
        return iServiceDislike.addDislike(dislikeComment,idUser,idComment);
    }
}
