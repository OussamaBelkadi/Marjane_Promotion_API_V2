package os.merjanepromotion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Caissier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NotNull
    protected String nom;
    @NotNull
    protected String prenom;
    @Email
    @NotNull
    @Column(unique=true)
    protected String email;
    @NotNull
    protected String password;
    @NotNull
    protected String username;
}
