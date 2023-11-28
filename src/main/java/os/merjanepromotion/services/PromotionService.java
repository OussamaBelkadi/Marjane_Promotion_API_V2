package os.merjanepromotion.services;

import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.dto.PromotionDto;

import java.util.Collection;
import java.util.List;

public interface PromotionService {
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto);
    public List<PromotionDto> getAll();

    Collection<PromotionDto> consulterListPromotionValide();

    Collection<PromotionDto> consulterListPromotionValideParId(int id);
    Collection<PromotionDto> consulterListPromotionPourResponsableRayon(int id);
}
