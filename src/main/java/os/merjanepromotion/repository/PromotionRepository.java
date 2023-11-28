package os.merjanepromotion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.enums.StatusPromotion;

import java.util.Collection;


@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    public Promotion findByDescription(String description);
    public Collection<Promotion> findAllByStatus(StatusPromotion status);


//    @Query("""
//            select p from Promotion  p join p.produits pr where pr.quantite > 0 and p.status = 'EN_COURS' and p.dateDebut <= CURRENT_DATE and p.dateFin >= CURRENT_DATE
//""")
//    public Collection<Promotion> GetPromotionByProuitQuntiteEtPromotionIsEnCoursEtValable();
//
//    public Collection<Promotion> GetPromotionByProuitQuntiteEtPromotionIsEnCoursEtValableByReponsable(Long id );
//
//    public Collection<Promotion> findAllByCentre_Id(Long id);
    



}
