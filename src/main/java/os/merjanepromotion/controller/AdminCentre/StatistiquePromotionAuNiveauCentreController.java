package os.merjanepromotion.controller.AdminCentre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import os.merjanepromotion.dto.PromotionCentreRequestDto;
import os.merjanepromotion.dto.PromotionDto;
import os.merjanepromotion.dto.PromotionStatistique;
import os.merjanepromotion.services.PromotiomAuNiveauCentreService;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/statistics/promotion/centre")
public class StatistiquePromotionAuNiveauCentreController {

    private os.merjanepromotion.services.PromotiomAuNiveauCentreService PromotiomAuNiveauCentreService;

    @Autowired
    public StatistiquePromotionAuNiveauCentreController( PromotiomAuNiveauCentreService promotiomAuNiveauCentreService) {
        PromotiomAuNiveauCentreService = promotiomAuNiveauCentreService;
    }


    @GetMapping()
    public Collection<PromotionDto> listPromotion(@PathVariable PromotionCentreRequestDto promotionCentreRequestDto) {
        return this.PromotiomAuNiveauCentreService.ListPromotion(promotionCentreRequestDto);
    }
    @PostMapping()
    public Collection<PromotionStatistique> StatisticPromotionCentre(@RequestBody PromotionCentreRequestDto promotionCentreRequestDto){
         return this.PromotiomAuNiveauCentreService.StatisticPromotionCentre(promotionCentreRequestDto);
    }
}
