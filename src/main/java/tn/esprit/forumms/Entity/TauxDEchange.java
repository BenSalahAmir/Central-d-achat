package tn.esprit.forumms.Entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TauxDEchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviseOrigine;

    private String deviseDestination;


    private Double taux;

    @ManyToOne
    private Devise devise;
}
