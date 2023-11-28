package os.merjanepromotion.services;

import os.merjanepromotion.dto.PromotionCentreRequestDto;
import os.merjanepromotion.dto.PromotionDto;
import os.merjanepromotion.dto.PromotionStatistique;

import java.util.Collection;

public interface PromotiomAuNiveauCentreService {
    Collection<PromotionDto> ListPromotion(PromotionCentreRequestDto promotionCentreRequestDto);
    Collection<PromotionStatistique> StatisticPromotionCentre(PromotionCentreRequestDto promotionCentreRequestDto);
}
