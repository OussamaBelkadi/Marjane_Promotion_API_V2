package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.PromotionCentreRequestDto;
import os.merjanepromotion.dto.PromotionDto;
import os.merjanepromotion.dto.PromotionStatistique;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.mapper.PromotiomMapper;
import os.merjanepromotion.mapper.StatisticPromotionMapper;
import os.merjanepromotion.repository.PromotionAuNiveauCentreRepository;
import os.merjanepromotion.services.PromotiomAuNiveauCentreService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Transactional
@Service("PromotiomAuNiveauCentreServiceImpl")
public class PromotiomAuNiveauCentreServiceImp implements PromotiomAuNiveauCentreService {
    private PromotionAuNiveauCentreRepository promotionAuNiveauCentreRepository;

    @Autowired
    public PromotiomAuNiveauCentreServiceImp(PromotionAuNiveauCentreRepository promotionAuNiveauCentreRepository){
        this.promotionAuNiveauCentreRepository = promotionAuNiveauCentreRepository;
    }

    @Override
    public Collection<PromotionDto> ListPromotion(PromotionCentreRequestDto promotionCentreRequestDto) {
        Collection<PromotionDto> listPromotions = new ArrayList<>();
        Optional<Collection<Promotion>> promotions = promotionAuNiveauCentreRepository.findAllByCentre_id(promotionCentreRequestDto.getCentre_id());
        if (promotions.isPresent()){
            for (Promotion promotion: promotions.get()){
                PromotionDto promotionDto = PromotiomMapper.promotionMapper.toDto(promotion);
                listPromotions.add(promotionDto);
            }
            return listPromotions;
        }
        return null;
    }

    @Override
    public Collection<PromotionStatistique> StatisticPromotionCentre(PromotionCentreRequestDto promotionCentreRequestDto) {
        Collection<PromotionStatistique> promotionStatistiques = new ArrayList<>();
        Optional<Collection<Promotion>> promotions = promotionAuNiveauCentreRepository.findAllByCentre_id(promotionCentreRequestDto.getCentre_id());
        if (promotions.isPresent()){
            for (Promotion promotion: promotions.get()){
                PromotionStatistique promotionStatistique = StatisticPromotionMapper.statisticPromotionMapper.toDto(promotion);
                promotionStatistiques.add(promotionStatistique);
            }
            return promotionStatistiques;
        }
        return null;
    }
}
