package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.PromotionStatistique;
import os.merjanepromotion.dto.PromotionStatistiques;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.enums.StatusPromotion;
import os.merjanepromotion.mapper.PromotionStatistiqueMapper;
import os.merjanepromotion.repository.StatisticsPromotionsAuNiveauDuRoyaumeRepository;
import os.merjanepromotion.services.StatisticsPromotionsAuNiveauDuRoyaumeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl implements StatisticsPromotionsAuNiveauDuRoyaumeService {




    private StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository ;

    @Autowired
    public StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl(StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository  ) {
        this.statisticsPromotionsAuNiveauDuRoyaumeRepository = statisticsPromotionsAuNiveauDuRoyaumeRepository;
    }


    @Transactional
    @Override
    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String... status) {

        Collection<PromotionStatistiques> promotionStatistiques = new ArrayList<>();
        if (status.length ==0){
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.ACCPETER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.REFUSER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.EN_ATTENTE));

       }else {
           StatusPromotion statusPromotion = StatusPromotion.valueOf(status[0]);
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(statusPromotion));
       }


        return promotionStatistiques;



    }

    private PromotionStatistiques getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion statusPromotion) {
        Optional<Collection<Promotion>> promotionsList =  this.statisticsPromotionsAuNiveauDuRoyaumeRepository.findAllByStatus(statusPromotion);
        Collection<PromotionStatistique> promotionStatistiques = new ArrayList<>();

        if (promotionsList.isPresent()){
            for (Promotion promotion : promotionsList.get()){
                PromotionStatistique promotionStatistique  = PromotionStatistiqueMapper.promotionMapper.toDto(promotion);
                promotionStatistiques.add(promotionStatistique);
            }
            
            PromotionStatistiques promotionStatistiquesList = new PromotionStatistiques();
            promotionStatistiquesList.setSize(promotionsList.get().size());
            promotionStatistiquesList.setStatus(statusPromotion);
            promotionStatistiquesList.getPromoitons().addAll(promotionStatistiques);

            return promotionStatistiquesList;
        }
        return null;
    }
}
