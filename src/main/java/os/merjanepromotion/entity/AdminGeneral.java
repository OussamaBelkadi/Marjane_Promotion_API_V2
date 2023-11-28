package os.merjanepromotion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
@Table(name = "admin_general")
public class AdminGeneral {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Size(min=0,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    protected String telephone;

    private String lastAccess;




}
