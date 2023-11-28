package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.Promotion;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PromotionAuNiveauCentreRepository extends JpaRepository<Promotion, Long> {
    Optional<Collection<Promotion>> findAllByCentre_idAndStatus(Long id, String status);
    Optional<Collection<Promotion>> findAllByCentre_id(Long id);

}
