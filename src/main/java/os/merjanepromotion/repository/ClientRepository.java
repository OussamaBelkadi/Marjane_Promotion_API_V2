package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import os.merjanepromotion.entity.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByCodeClient(String code);
}
