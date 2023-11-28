package os.merjanepromotion.mapper.client;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.clientDto.FideliterDto;
import os.merjanepromotion.entity.Fidelite;

@Mapper
public interface RequestFideliterMapper {
    RequestFideliterMapper INSTANCE = Mappers.getMapper(RequestFideliterMapper.class);
    @Mapping(source = "total", target = "total")
    Fidelite toEntity(FideliterDto fideliterDto);
    @Mapping(source = "total", target = "total")

    FideliterDto toDto(Fidelite fidelite);
}
