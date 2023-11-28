package os.merjanepromotion.mapper.client;

import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import os.merjanepromotion.dto.clientDto.ClientDto;
import os.merjanepromotion.entity.Client;
@Mapper(componentModel = "spring")
public interface RequestClientMapper {
    RequestClientMapper INSTANCE = Mappers.getMapper(RequestClientMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "codeClient", target = "codeClient")
    Client toEntity(ClientDto clientDto);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "email", target = "email")
    ClientDto toDto(Client client);
}
