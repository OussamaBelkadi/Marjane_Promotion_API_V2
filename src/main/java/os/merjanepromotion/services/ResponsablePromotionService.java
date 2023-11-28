package os.merjanepromotion.services;


import os.merjanepromotion.dto.ResponsablePromotionRequest;
import os.merjanepromotion.dto.ResponsablePromotionResponse;

public interface ResponsablePromotionService {

    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest);

}
