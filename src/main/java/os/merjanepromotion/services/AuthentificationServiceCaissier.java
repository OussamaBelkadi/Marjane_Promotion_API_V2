package os.merjanepromotion.services;

import os.merjanepromotion.dto.CaissierDto;

public interface AuthentificationServiceCaissier {
    CaissierDto register(CaissierDto caissierDto);
    CaissierDto login(CaissierDto caissierDto);
}
