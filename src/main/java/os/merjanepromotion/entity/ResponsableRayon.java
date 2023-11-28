package os.merjanepromotion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="responsable_rayon")
public class ResponsableRayon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;
    private String version;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATED_AT")
    protected LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre  centre;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rayon_id") // assuming the column name in the database
    private Rayon rayon;


}
