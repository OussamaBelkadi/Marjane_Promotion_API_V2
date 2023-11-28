package os.merjanepromotion.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String description;
    private String image;
    private String slug;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Rayon rayon;


    @ManyToMany
    @JoinTable(
            name = "categorie_centre",
            joinColumns = { @JoinColumn(name = "categorie_id") },
            inverseJoinColumns = { @JoinColumn(name = "center_id") }
    )
    private Collection<Centre> centres = new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY)
   private Promotion promotion;




}
