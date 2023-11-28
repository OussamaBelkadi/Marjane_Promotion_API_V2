package os.merjanepromotion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.AdminGeneralDto;
import os.merjanepromotion.dto.CaissierDto;
import os.merjanepromotion.entity.AdminGeneral;
import os.merjanepromotion.entity.Caissier;

@Mapper
public interface CaissierMapper {
    CaissierMapper adminGeneralMapper = Mappers.getMapper(CaissierMapper.class);

    Caissier toEntity(CaissierDto caissierDto);

    CaissierDto toDto(Caissier caissier);
}
