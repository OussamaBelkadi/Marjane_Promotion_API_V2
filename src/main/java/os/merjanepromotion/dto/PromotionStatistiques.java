package os.merjanepromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import os.merjanepromotion.enums.StatusPromotion;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionStatistiques {
    private int size ;
    private StatusPromotion status;
    private Collection<PromotionStatistique> promoitons = new ArrayList<>();
}
