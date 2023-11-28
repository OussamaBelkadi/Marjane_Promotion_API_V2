package os.merjanepromotion.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.entity.Produit;

@Mapper
public interface ProduitMapper {
    ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);

    Produit toEntity(ProduitDto produitDto);

    ProduitDto toDto(Produit produit);
}
