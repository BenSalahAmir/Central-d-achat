package tn.esprit.forumms.DTOentities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.esprit.forumms.Entity.CommentPost;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {
    private final Long idUser;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String country;
    private final String gouvernment;
    private final Boolean banned;
    private final Boolean etat;
    private final Boolean verified;
    private final int phone;
    private final Boolean disponibilite;
    private final String image;
    private final LocalDateTime createdate;
    private final tn.esprit.forumms.Entity.ERole ERole;
    private final List<CommentPost> commentList;
}