package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.RayonDto;
import os.merjanepromotion.entity.Rayon;


@Mapper
public interface RayonMapper {
    RayonMapper rayonMapper = Mappers.getMapper(RayonMapper.class);

    Rayon toEntity(RayonDto rayonDto);
    RayonDto toDto(Rayon rayon);
}
