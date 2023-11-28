package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.ResponsableRayon;

@Repository
public interface ResponsableRayonRepository extends JpaRepository<ResponsableRayon,Long>{
    public ResponsableRayon findByEmail(String email);
}
