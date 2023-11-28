package os.merjanepromotion.controller.AdminCentre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.merjanepromotion.dto.AdminCentreDto;
import os.merjanepromotion.services.AuthentificationService;
import os.merjanepromotion.services.AuthentificationServiceAdmCtr;

@RestController
@RequestMapping("/api/v1/admin_centres")
public class AuthentificationController {


    private final AuthentificationService<AdminCentreDto> authentificationService;


    @Autowired
    public AuthentificationController(@Qualifier("AdminCentreAuthentificationServiceImpl") AuthentificationServiceAdmCtr authentificationService){
        this.authentificationService = authentificationService;
    }
    @PostMapping("/register")
    public AdminCentreDto register(@RequestBody AdminCentreDto adminCentreDto){
            return authentificationService.register(adminCentreDto);
    }
    @PostMapping ("/login")
    public AdminCentreDto login(@RequestBody AdminCentreDto adminCentreDto){
        return authentificationService.login(adminCentreDto);
    }

}
