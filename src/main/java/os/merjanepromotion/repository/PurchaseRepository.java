package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.PurchaseHistory;
@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseHistory, Integer> {
}
