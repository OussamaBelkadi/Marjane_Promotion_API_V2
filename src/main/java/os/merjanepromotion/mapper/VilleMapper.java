package os.merjanepromotion.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.VilleDto;
import os.merjanepromotion.entity.Ville;

@Mapper
public interface VilleMapper {
    VilleMapper villeMapper = Mappers.getMapper(VilleMapper.class);

    Ville toEntity(VilleDto villeDto);
    VilleDto toDto(Ville ville);
}
