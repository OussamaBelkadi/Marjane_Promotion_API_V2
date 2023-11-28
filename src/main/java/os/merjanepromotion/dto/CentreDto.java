package os.merjanepromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import os.merjanepromotion.entity.Ville;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CentreDto {
    private Ville ville;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
}
