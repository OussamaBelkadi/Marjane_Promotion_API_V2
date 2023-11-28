package os.merjanepromotion.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class PurchaseHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_Achat;
    @ManyToOne
    @JoinTable(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinTable(name = "produit_id")
    private Produit produit;

}
