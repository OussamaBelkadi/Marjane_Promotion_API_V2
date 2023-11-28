package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.ResponsablePromotionDto;
import os.merjanepromotion.dto.ResponsablePromotionRequest;
import os.merjanepromotion.dto.ResponsablePromotionResponse;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.entity.ResponsableRayon;
import os.merjanepromotion.mapper.ResponsablePromotoinMapper;
import os.merjanepromotion.repository.PromotionRepository;
import os.merjanepromotion.repository.ResponsableRayonRepository;
import os.merjanepromotion.services.ResponsablePromotionService;

import java.util.Optional;


@Service
@Transactional
public class ResponsablePromotionServiceImpl implements ResponsablePromotionService {

    private final ResponsableRayonRepository responsableRayonRepository;
    private final PromotionRepository promotionRepository ;
    private ResponsablePromotoinMapper responsablePromotoinMapper ;

    @Autowired
    public ResponsablePromotionServiceImpl(ResponsableRayonRepository responsableRayonRepository, PromotionRepository promotionRepository) {
        this.responsableRayonRepository = responsableRayonRepository;
        this.promotionRepository = promotionRepository;
        this.responsablePromotoinMapper = ResponsablePromotoinMapper.INSTANCE;
    }
    @Override
    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest) {
        // first find the responsible .
        ResponsablePromotionResponse response  = new ResponsablePromotionResponse();

        this.findResponsableById(responsablePromotionRequest.getResponsableId());

        // :  loop into promotion and update their status
        if (responsablePromotionRequest.getPromotionList().isEmpty()){
            return response;
        }else{
            for(ResponsablePromotionDto promotionDto : responsablePromotionRequest.getPromotionList()){
                Optional<Promotion> promotion = this.promotionRepository.findById(promotionDto.getId());
                if (promotion.isPresent()){
                    Promotion promotion1 = promotion.get();
                    promotion1.setStatus(promotionDto.getStatus());
                    this.promotionRepository.save(promotion1);
                    response.getPromotionDtos().add(this.responsablePromotoinMapper.toDto(promotion.get()));

                }
//                else{
//                    response.getPromotionDtos().add(promotionDto);
//                }
            }
        }
        return response;
    }

    public ResponsableRayon findResponsableById(Long responsableId){
        if (responsableId <1 ){
            return null;
        }

        Optional<ResponsableRayon> responsable = this.responsableRayonRepository.findById(responsableId);
        return responsable.orElseThrow(
                ()-> new RuntimeException("Responsible not found")
        );
    }
}
