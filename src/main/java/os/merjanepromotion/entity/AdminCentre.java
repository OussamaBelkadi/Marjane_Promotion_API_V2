package os.merjanepromotion.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "admin_centre")
public class AdminCentre  {
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
    @ManyToOne
    private Ville ville ;
    @OneToOne
    private Centre centre ;

}
