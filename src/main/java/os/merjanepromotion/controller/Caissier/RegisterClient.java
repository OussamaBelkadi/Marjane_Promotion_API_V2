package os.merjanepromotion.controller.Caissier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.merjanepromotion.dto.clientDto.ClientDto;
import os.merjanepromotion.dto.clientDto.RequestRegisterClientDto;
import os.merjanepromotion.services.PurschaseClientService;
import os.merjanepromotion.services.impl.PurchaseClientServiceImpl;

@RestController
@RequestMapping("api/v1/caissier/clients")
public class RegisterClient {
    private PurschaseClientService purchaseClientService;
    @Autowired
    public RegisterClient(PurschaseClientService purchaseClientService){
        this.purchaseClientService = purchaseClientService;
    }

    @PostMapping("/Purchise")
    public RequestRegisterClientDto purchase(@RequestBody RequestRegisterClientDto registerClientDto){
        this.purchaseClientService.purchase(registerClientDto);
        return registerClientDto;
    }
}
