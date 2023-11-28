package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.ResponsableDto;
import os.merjanepromotion.entity.ResponsableRayon;

@Mapper
public interface ResponsableMapper {
    ResponsableMapper Instance = Mappers.getMapper(ResponsableMapper.class);
    ResponsableRayon toEntity(ResponsableDto responsableDto);

    ResponsableDto toDto(ResponsableRayon responsableRayon);
}
