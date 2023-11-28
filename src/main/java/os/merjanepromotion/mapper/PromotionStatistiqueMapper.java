package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.PromotionStatistique;
import os.merjanepromotion.entity.Promotion;

@Mapper
public interface PromotionStatistiqueMapper
{

    PromotionStatistiqueMapper promotionMapper = Mappers.getMapper(PromotionStatistiqueMapper.class);

//    @Mapping(target = "Promotion.update", source = "promotionStatistique.date_applique")
    Promotion toEntity(PromotionStatistique promotionStatistique);

//    @Mapping(target = "PromotionStatistique.date_applique", source = "promotion.updatedAt")
    PromotionStatistique toDto(Promotion promotion);
}
