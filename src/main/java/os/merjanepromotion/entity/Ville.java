package os.merjanepromotion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ville extends AbstractEntity {

    private String nom;
    private String codePostal;
    private String slug;
    private String image;
    @OneToMany(mappedBy = "ville")
    private Collection<Centre> centres = new ArrayList<>();



}
