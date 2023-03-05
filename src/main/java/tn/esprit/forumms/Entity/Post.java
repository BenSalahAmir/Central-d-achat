package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JsonIgnore
    @ManyToOne
    private CategoryProduct categoryPost;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<CommentPost> commentList;

    @JsonIgnore
    @ManyToOne
    private User userPost;



}

