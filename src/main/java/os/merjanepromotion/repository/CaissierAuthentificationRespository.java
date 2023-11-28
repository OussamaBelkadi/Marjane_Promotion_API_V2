package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.AdminGeneral;
import os.merjanepromotion.entity.Caissier;

@Repository
public interface CaissierAuthentificationRespository extends JpaRepository<Caissier, Long> {
    public Caissier findByEmail(String email);
    

}
