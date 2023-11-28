package os.merjanepromotion.controller.Promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.dto.PromotionDTo.PromotionRequestDto;
import os.merjanepromotion.dto.PromotionDto;
import os.merjanepromotion.dto.promotionRequest;
import os.merjanepromotion.exceptions.business.NotFoundException;
import os.merjanepromotion.services.PromotionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<PromotionDto> getAll(){
//        throw new RuntimeException("not implemented yet");
        return this.promotionService.getAll();
    }

    @GetMapping("/{id}/produits")
    public List<ProduitDto> getProduits(@PathVariable("id") Long id){
        // TODO: 15/11/2023 implement this method
//        return this.promotionService.getProduits(id);
        return null;

    }

    @PostMapping("/product")
    public ResponseEntity<?> promotionProduct(@RequestBody PromotionRequestDto promotionRequestDto){
        try{
            PromotionDto promotionDto = promotionRequestDto.getPromotionDto();
            ProduitDto produitDto =promotionRequestDto.getProduitDto();
            produitDto = this.promotionService.addPromotion(produitDto,promotionDto);
            return  ResponseEntity.ok(produitDto);
        }catch(NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
