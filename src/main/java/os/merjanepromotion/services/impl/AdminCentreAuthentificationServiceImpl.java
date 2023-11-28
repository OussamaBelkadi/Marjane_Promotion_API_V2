package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.AdminCentreDto;
import os.merjanepromotion.entity.AdminCentre;
import os.merjanepromotion.exceptions.business.NotFoundException;
import os.merjanepromotion.mapper.AdminCentreMapper;
import os.merjanepromotion.repository.AdminCentreAuthetificationRepository;
import os.merjanepromotion.services.AuthentificationServiceAdmCtr;

@Service("AdminCentreAuthentificationServiceImpl")
@Transactional
public class AdminCentreAuthentificationServiceImpl implements AuthentificationServiceAdmCtr<AdminCentreDto> {

    private final AdminCentreAuthetificationRepository adminCentreAuthetificationRepository;
    @Autowired
    public AdminCentreAuthentificationServiceImpl(AdminCentreAuthetificationRepository adminCentreAuthetificationRepository){
        this.adminCentreAuthetificationRepository = adminCentreAuthetificationRepository;
    }

    @Override
    public boolean logout() {
        return false;
    }


    @Override
    public AdminCentreDto login(AdminCentreDto adminCentreDto) {
        boolean result = false;
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        AdminCentre adminCentreRslt =adminCentreAuthetificationRepository.findByEmail(adminCentre.getEmail());
        if(adminCentreRslt != null){
            if (BCrypt.checkpw(adminCentre.getPassword(), adminCentreRslt.getPassword())){
                result = true;
            }
        }
        if (result){
            return AdminCentreMapper.adminCentreMapper.toDto(adminCentreRslt);
        }
        throw new NotFoundException("Email ou mot de passe incorrect");

    }

    @Override
    public AdminCentreDto register(AdminCentreDto adminCentreDto) {
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        adminCentre.setPassword(BCrypt.hashpw(adminCentre.getPassword(), BCrypt.gensalt()));
        adminCentre = adminCentreAuthetificationRepository.save(adminCentre);
        return AdminCentreMapper.adminCentreMapper.toDto(adminCentre);
    }
    @Override
    public boolean deleteAdminCentre(AdminCentreDto adminCentreDto){
        AdminCentre adminCentre = AdminCentreMapper.adminCentreMapper.toEntity(adminCentreDto);
        adminCentreAuthetificationRepository.findById(adminCentre.getId())
                .orElseThrow(() -> new NotFoundException("Admin Centre n'existe pas")) ;
        adminCentreAuthetificationRepository.delete(adminCentre);
        return false;
    }
}
