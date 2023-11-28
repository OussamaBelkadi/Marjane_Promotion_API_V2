package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import os.merjanepromotion.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
