package ma.enset.tp2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissanec;
    private boolean malade;
    private int score;
}
