package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.AdminGeneralDto;
import os.merjanepromotion.entity.AdminGeneral;

@Mapper
public interface AdminGeneralMapper {
    AdminGeneralMapper adminGeneralMapper = Mappers.getMapper(AdminGeneralMapper.class);

    AdminGeneral toEntity(AdminGeneralDto adminGeneralDto);

    AdminGeneralDto toDto(AdminGeneral adminGeneral);
}
