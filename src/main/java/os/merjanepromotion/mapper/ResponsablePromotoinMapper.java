package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.ResponsablePromotionDto;
import os.merjanepromotion.entity.Promotion;

@Mapper
public interface ResponsablePromotoinMapper {
    ResponsablePromotoinMapper INSTANCE = Mappers.getMapper(ResponsablePromotoinMapper.class);

    Promotion toEntity(ResponsablePromotionDto responsablePromotionDto);

    ResponsablePromotionDto toDto(Promotion promotion);
}
