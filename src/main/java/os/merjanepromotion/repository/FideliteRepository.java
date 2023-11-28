package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import os.merjanepromotion.entity.Caissier;
import os.merjanepromotion.entity.Client;
import os.merjanepromotion.entity.Fidelite;

import java.util.Optional;

public interface FideliteRepository extends JpaRepository<Fidelite, Integer> {
    public Optional<Fidelite> findByClient(Client client);
}
