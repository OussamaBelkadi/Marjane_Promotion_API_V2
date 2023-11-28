package os.merjanepromotion.mapper;

import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.ProuitStatisticDto;
import os.merjanepromotion.entity.Produit;

public interface ProuitStatisticMapper {

    PromotionStatistiqueMapper INSTANCE = Mappers.getMapper(PromotionStatistiqueMapper.class);
    ProuitStatisticDto toDto(Produit produit);
}
