package os.merjanepromotion.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CaissierDto {
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
