package os.merjanepromotion.dto.clientDto;

import lombok.*;
import os.merjanepromotion.entity.Fidelite;


@Data @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ClientDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String ville;
    private String codeClient;
    private Fidelite fidelite;

}
