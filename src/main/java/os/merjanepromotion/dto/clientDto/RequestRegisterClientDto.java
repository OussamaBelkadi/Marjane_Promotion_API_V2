package os.merjanepromotion.dto.clientDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import os.merjanepromotion.dto.ProduitDto;

@Data @Setter @Getter

public class RequestRegisterClientDto {
    private ClientDto clientDto;
    private FideliterDto fidelite;
    private ProduitDto produitDto;
}
