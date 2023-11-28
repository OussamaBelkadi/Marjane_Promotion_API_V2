package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.AdminGeneralDto;
import os.merjanepromotion.dto.CaissierDto;
import os.merjanepromotion.entity.AdminGeneral;
import os.merjanepromotion.entity.Caissier;
import os.merjanepromotion.exceptions.business.NotFoundException;
import os.merjanepromotion.mapper.AdminGeneralMapper;
import os.merjanepromotion.mapper.CaissierMapper;
import os.merjanepromotion.repository.AdminGeneralAuthentificationRespository;
import os.merjanepromotion.repository.CaissierAuthentificationRespository;
import os.merjanepromotion.services.AuthentificationService;
import os.merjanepromotion.util.Utils;

@Service
@Transactional
@Qualifier("CaisseServiceImpl")
public class CaissierAuthentificationServiceImpl implements AuthentificationService<CaissierDto> {



    @Autowired
    private CaissierAuthentificationRespository caissierAuthentificationRespository;




    @Override
    public CaissierDto login(CaissierDto caissierDto) {
        Caissier caissier = this.caissierAuthentificationRespository.findByEmail(caissierDto.getEmail());
        if(caissier != null){
            if(BCrypt.checkpw(caissierDto.getPassword(),caissier.getPassword())){
                caissierDto.setEmail(caissier.getEmail());
                caissierDto.setPassword(caissier.getPassword());
                caissierDto.setNom(caissier.getNom());
                return caissierDto;
            }else{
                throw new NotFoundException(" mot de passe incorrect");
            }
        }
        throw new NotFoundException("Email incorrect");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public CaissierDto register(CaissierDto caissierDto) {
        Caissier caissier = CaissierMapper.adminGeneralMapper.toEntity(caissierDto);
        caissier.setPassword(BCrypt.hashpw(caissier.getPassword(), BCrypt.gensalt()));
        caissier = this.caissierAuthentificationRespository.save(caissier);
        return CaissierMapper.adminGeneralMapper.toDto(caissier);
    }
}
