package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.AdminCentre;

@Repository
public interface AdminCentreAuthetificationRepository extends JpaRepository<AdminCentre, Long> {
    public AdminCentre findByEmail(String email);
}
