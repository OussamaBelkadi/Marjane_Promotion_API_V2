package os.merjanepromotion.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter @Setter
public class Produit  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String nom ;
    private String description ;
    private String image;
    private double prix;
    private int quantite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie catfegorie;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
    private String version;
    @OneToMany(mappedBy = "produit")
    private Collection<PurchaseHistory> purchaseHistory = new ArrayList<>();
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATED_AT")
    protected LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;

}

