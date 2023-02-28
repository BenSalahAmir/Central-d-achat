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

public class DislikeComment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDislike;

    @JsonIgnore
    @ManyToOne
    private CommentPost commentPost;

    @JsonIgnore
    @ManyToOne
    private User user;
}
