package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.PromotionDto;
import os.merjanepromotion.entity.Promotion;

@Mapper
public interface PromotiomMapper {
    PromotiomMapper promotionMapper = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    PromotionDto toDto(Promotion promotion);
}
