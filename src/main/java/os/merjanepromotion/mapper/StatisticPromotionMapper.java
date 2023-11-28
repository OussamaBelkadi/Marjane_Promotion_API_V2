package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.PromotionStatistique;
import os.merjanepromotion.entity.Promotion;

@Mapper
public interface StatisticPromotionMapper {
    StatisticPromotionMapper statisticPromotionMapper = Mappers.getMapper(StatisticPromotionMapper.class);

    Promotion toEntity(PromotionStatistique promotionStatistique);

    PromotionStatistique toDto(Promotion promotion);
}
