package os.merjanepromotion.services;

import os.merjanepromotion.dto.clientDto.ClientDto;
import os.merjanepromotion.dto.clientDto.RequestRegisterClientDto;

public interface PurschaseClientService {
    ClientDto purchase(RequestRegisterClientDto registerClientDto);
}
