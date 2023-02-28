package tn.esprit.forumms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LikeComment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idLike;

    @JsonIgnore
    @ManyToOne
    private CommentPost commentPost;

    @JsonIgnore
    @ManyToOne
    private User user;
}
