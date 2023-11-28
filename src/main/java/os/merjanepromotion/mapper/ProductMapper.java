package os.merjanepromotion.mapper;

import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.ProduitDto;
import os.merjanepromotion.entity.Produit;
@Service
public class ProductMapper {

    public static ProduitDto toDto(Produit produit) {
        ProduitDto produitDto = new ProduitDto();
        produitDto.setId(produit.getId());
        produitDto.setNom(produit.getNom());
        produitDto.setDescription(produit.getDescription());
        produitDto.setImage(produit.getImage());
        produitDto.setPrix(produit.getPrix());
        produitDto.setQuantite(produit.getQuantite());
        // Map other fields as needed

        return produitDto;
    }

    public static Produit toEntity(ProduitDto produitDto) {
        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setNom(produitDto.getNom());
        produit.setDescription(produitDto.getDescription());
        produit.setImage(produitDto.getImage());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantite(produitDto.getQuantite());
        // Map other fields as needed

        return produit;
    }
}
