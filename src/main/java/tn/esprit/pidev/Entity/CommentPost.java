package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentPost implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComment;
    @Temporal(TemporalType.DATE)
    private Date dateCreationComment;
    private String descriptionComment;
    private Long liked;
    private Long disliked;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User userComment;


   @OneToOne(mappedBy = "comment")
    private Product productForum;


}
