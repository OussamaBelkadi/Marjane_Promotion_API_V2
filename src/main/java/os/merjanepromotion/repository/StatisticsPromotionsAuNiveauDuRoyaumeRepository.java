package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.enums.StatusPromotion;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface StatisticsPromotionsAuNiveauDuRoyaumeRepository extends JpaRepository<Promotion ,Long> {

    public Optional<Collection<Promotion>> findAllByStatus(StatusPromotion statusPromotion);
}
