package os.merjanepromotion.controller.ResponsableRayonController;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import os.merjanepromotion.dto.ResponsableDto;
import os.merjanepromotion.services.AuthentificationService;

@RestController
@RequestMapping("/api/v1/responsable-rayon")
public class ResponsableAuthController {



    private AuthentificationService<ResponsableDto> authentificationService;

    public ResponsableAuthController(@Qualifier("ResponsableRayonAuthentificationService") AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/login")
    public ResponsableDto login(@RequestBody ResponsableDto responsableDto){
        return this.authentificationService.login(responsableDto);
//        return this.authentificationService.login(userDto);
    }

    @PostMapping("/register")
    public ResponsableDto register(@RequestBody  ResponsableDto responsableDto){
        return authentificationService.register(responsableDto);
    }

    @GetMapping("/logout")
    public boolean logout(){
        return authentificationService.logout();
    }

    @GetMapping("/resetPassword")
    public boolean resetPassword(){
        return false;
    }

    @GetMapping("/refershToken")
    public boolean refershToken(){
        return false;
    }

}
