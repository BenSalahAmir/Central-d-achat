package tn.esprit.forumms.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idNotification;
    private String topic;
    private String message;

    @ManyToOne
    private CommentPost commentPost;



}
