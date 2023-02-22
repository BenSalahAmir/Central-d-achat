package tn.esprit.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPost;
    private String topicPost;
    private String descriptionPost;
    private String imagePost;
    @Temporal(TemporalType.DATE)
    private Date dateCreationPost;

    @ManyToOne
    private CategoryProduct categoryPost;


    @OneToMany(mappedBy = "post")
    private List<CommentPost> commentList;

    @ManyToOne
    private User userPost;




}
