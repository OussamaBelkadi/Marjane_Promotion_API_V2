package os.merjanepromotion.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter

public class Client  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String ville;
    private String codeClient;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<PurchaseHistory> purchaseHistories = new ArrayList<>();
    @OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
    private Fidelite fidelite;
}
