package os.merjanepromotion.dto.PromotionDTo;

import lombok.*;
import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.dto.PromotionDto;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class PromotionRequestDto {
    private ProduitDto produitDto;
    private PromotionDto promotionDto;
}
