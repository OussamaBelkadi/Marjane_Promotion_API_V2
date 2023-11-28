package os.merjanepromotion.entity;

import jakarta.persistence.*;

import java.util.UUID;

public class CarteFidelite {
    @Id @GeneratedValue(generator = "UUID")
    private UUID idCarte;
    private double totalCarte;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
