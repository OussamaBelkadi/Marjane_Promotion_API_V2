package os.merjanepromotion.controller.ResponsableRayonController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.merjanepromotion.dto.ResponsablePromotionRequest;
import os.merjanepromotion.dto.ResponsablePromotionResponse;
import os.merjanepromotion.services.ResponsablePromotionService;

@RestController
@RequestMapping("/api/v1/responsables-promotion")
public class ApprouverOuRefuserPromotionController {


    private ResponsablePromotionService responsablePromotionService ;



    @Autowired
    public ApprouverOuRefuserPromotionController(ResponsablePromotionService responsablePromotionService) {
        this.responsablePromotionService = responsablePromotionService;
    }


    @PostMapping()
    public ResponsablePromotionResponse approuverOuRefuserPromotion(@RequestBody ResponsablePromotionRequest responsablePromotionRequest){
        return  this.responsablePromotionService.ApprouverOuRefuserPromotion(responsablePromotionRequest);

    }
}
