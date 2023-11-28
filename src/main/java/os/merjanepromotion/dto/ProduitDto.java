package os.merjanepromotion.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@Builder
public class ProduitDto {
    private Long id;
    private String nom ;
    private String description ;
    private String image ;
    private double prix ;
    private int quantite ;
}
