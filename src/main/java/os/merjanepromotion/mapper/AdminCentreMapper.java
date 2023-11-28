package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.AdminCentreDto;
import os.merjanepromotion.entity.AdminCentre;

@Mapper
public interface AdminCentreMapper {
    AdminCentreMapper adminCentreMapper = Mappers.getMapper(AdminCentreMapper.class);

    AdminCentre toEntity(AdminCentreDto adminCentreDto);

    AdminCentreDto toDto(AdminCentre adminCentre);

}
