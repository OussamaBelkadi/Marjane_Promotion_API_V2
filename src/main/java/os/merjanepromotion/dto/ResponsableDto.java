package os.merjanepromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponsableDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
}
