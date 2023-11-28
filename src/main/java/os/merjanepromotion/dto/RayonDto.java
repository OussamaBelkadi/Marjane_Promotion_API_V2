package os.merjanepromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import os.merjanepromotion.entity.ResponsableRayon;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RayonDto {
    private Long id;
    private String nom;
    private String description;
    private ResponsableDto responsableRayon;
}
