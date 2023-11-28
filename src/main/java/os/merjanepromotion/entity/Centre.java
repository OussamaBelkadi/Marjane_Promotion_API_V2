package os.merjanepromotion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder
@Entity
public class Centre{

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
    private String adresse;
    private String tel;
    private String email;


    @ManyToMany
    @JoinTable(
            name = "categorie_centre",
            joinColumns = { @JoinColumn(name = "center_id") },
            inverseJoinColumns = { @JoinColumn(name = "categorie_id") }
    )

    private Collection<Categorie> categories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville_id")
    private Ville ville;


    @OneToOne(mappedBy = "centre",cascade = CascadeType.ALL)
    private AdminCentre admin_centre;

    @OneToMany(mappedBy = "centre",cascade = CascadeType.ALL)
    private Collection<Rayon> rayons = new ArrayList<>();

    @OneToMany(mappedBy = "centre",cascade = CascadeType.ALL)
    private Collection<ResponsableRayon> responsableRayons = new ArrayList<>();





}
