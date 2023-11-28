package os.merjanepromotion.controller.Caissier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.merjanepromotion.dto.CaissierDto;
import os.merjanepromotion.services.AuthentificationService;
import os.merjanepromotion.services.impl.CaissierAuthentificationServiceImpl;

@RestController
@RequestMapping("api/v1/caissier")
public class CaissierController {
    private AuthentificationService<CaissierDto> authentificationService;
    @Autowired
    public CaissierController(@Qualifier("CaisseServiceImpl") AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }
    @PostMapping("/register")
    public CaissierDto register(@RequestBody CaissierDto caissierDto){
        return this.authentificationService.register(caissierDto);
    }
    @PostMapping("/login")
    public CaissierDto login(@RequestBody CaissierDto caissierDto){
        return this.authentificationService.login(caissierDto);
    }
}
