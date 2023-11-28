package os.merjanepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.AdminGeneral;

@Repository
public interface AdminGeneralAuthentificationRespository extends JpaRepository<AdminGeneral, Long> {
    public AdminGeneral findByEmail(String email);
    

}
