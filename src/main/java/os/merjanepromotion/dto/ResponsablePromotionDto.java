package os.merjanepromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import os.merjanepromotion.enums.StatusPromotion;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsablePromotionDto {
    private Long id ;
    private StatusPromotion status ;
}
