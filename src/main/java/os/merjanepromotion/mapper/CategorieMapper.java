package os.merjanepromotion.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.CategorieDto;
import os.merjanepromotion.entity.Categorie;

@Mapper
public interface CategorieMapper {

    CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    Categorie toEntity(CategorieDto categorieDto);

    CategorieDto toDto(Categorie categorie);
}
