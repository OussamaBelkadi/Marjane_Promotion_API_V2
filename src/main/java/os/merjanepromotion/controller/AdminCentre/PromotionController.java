package os.merjanepromotion.controller.AdminCentre;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import os.merjanepromotion.dto.PromotionCentreRequestDto;

@RestController("/api/v1/admin_centres/promotions")
public class PromotionController {

    @PostMapping
    public void addPromotion(@RequestBody @Valid PromotionCentreRequestDto promotionCentreRequestDto , @RequestHeader("Authorization") String token
                             ){



    }

}
