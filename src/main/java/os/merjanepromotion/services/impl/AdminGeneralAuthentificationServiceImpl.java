package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.AdminGeneralDto;
import os.merjanepromotion.entity.AdminGeneral;
import os.merjanepromotion.exceptions.business.NotFoundException;
import os.merjanepromotion.mapper.AdminGeneralMapper;
import os.merjanepromotion.repository.AdminGeneralAuthentificationRespository;
import os.merjanepromotion.services.AuthentificationService;
import os.merjanepromotion.util.Utils;

@Service
@Transactional
@Qualifier("AdminGeneralAuthentificationServiceImpl")
public class AdminGeneralAuthentificationServiceImpl implements AuthentificationService<AdminGeneralDto> {



    @Autowired
    private AdminGeneralAuthentificationRespository adminGeneralAuthentificationRespository;




    @Override
    public AdminGeneralDto login(AdminGeneralDto userDto) {
        AdminGeneral user1 = this.adminGeneralAuthentificationRespository.findByEmail(userDto.getEmail());
        if(user1 != null){
            if(Utils.hashPassword(userDto.getPassword()).equals(user1.getPassword())){
                AdminGeneralDto adminGeneralDto = new AdminGeneralDto();
                adminGeneralDto.setEmail(user1.getEmail());
                adminGeneralDto.setPassword(user1.getPassword());
                adminGeneralDto.setNom(user1.getNom());
                return adminGeneralDto;
            }else{
                throw new NotFoundException(" mot de passe incorrect");
            }
        }
        throw new NotFoundException("Email  incorrect");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public AdminGeneralDto register(AdminGeneralDto adminGeneralDto) {
        AdminGeneral adminGeneral = AdminGeneralMapper.adminGeneralMapper.toEntity(adminGeneralDto);
        adminGeneral.setPassword(Utils.hashPassword(adminGeneral.getPassword()));
        adminGeneral = this.adminGeneralAuthentificationRespository.save(adminGeneral);
        return AdminGeneralMapper.adminGeneralMapper.toDto(adminGeneral);
    }
}
