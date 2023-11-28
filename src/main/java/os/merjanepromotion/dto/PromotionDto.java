package os.merjanepromotion.dto;

import lombok.*;
import os.merjanepromotion.entity.Produit;
import os.merjanepromotion.enums.StatusPromotion;

import java.util.Collection;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter @Getter
public class PromotionDto {
    private Date createdAt;
    private Date updatedAt;
    private Double precentage;
    private String description;
    private StatusPromotion status;
    private Date dateDebut;
    private Date dateFin;

//    @Schema(description = "la list des promotions concrene par cette promotion")
    private Collection<Produit> produits;
}
