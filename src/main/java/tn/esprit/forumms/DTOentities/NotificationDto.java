package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.CommentPost;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class NotificationDto implements Serializable {
    private final String topic;
    private final String message;
    private final CommentPost commentPost;
}