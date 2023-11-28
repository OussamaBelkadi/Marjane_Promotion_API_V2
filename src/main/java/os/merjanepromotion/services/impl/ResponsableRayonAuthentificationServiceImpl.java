package os.merjanepromotion.services.impl;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import os.merjanepromotion.dto.ResponsableDto;
import os.merjanepromotion.entity.ResponsableRayon;
import os.merjanepromotion.mapper.ResponsableMapper;
import os.merjanepromotion.repository.ResponsableRayonRepository;
import os.merjanepromotion.services.AuthentificationService;
import os.merjanepromotion.util.Utils;

@Service
@Qualifier("ResponsableRayonAuthentificationService")
@Transactional
public class ResponsableRayonAuthentificationServiceImpl implements AuthentificationService<ResponsableDto> {


    private ResponsableRayonRepository responsableRayonRepository;
    private final ResponsableMapper responsableMapper = ResponsableMapper.Instance;
//    @Autowired
    public ResponsableRayonAuthentificationServiceImpl(ResponsableRayonRepository responsableRayonRepository) {
        this.responsableRayonRepository = responsableRayonRepository;

    }
    @Override
    public ResponsableDto login(ResponsableDto responsableDto) {
        ResponsableRayon responsableRayon = this.responsableRayonRepository.findByEmail(responsableDto.getEmail());
        if (responsableRayon !=null){

            if (Utils.checkPassword(responsableDto.getPassword(), responsableRayon.getPassword())){//                return true;
                return this.responsableMapper.toDto(responsableRayon);
            }
            throw new RuntimeException("password is not correct");
        }
        throw new RuntimeException("user not found");
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public ResponsableDto register(ResponsableDto responsableDto) {
        ResponsableRayon responsableRayon = this.responsableRayonRepository.findByEmail(responsableDto.getEmail());
        if (responsableRayon == null){
            ResponsableRayon responsableRayon1 = this.responsableMapper.toEntity(responsableDto);
            responsableRayon1.setPassword(Utils.hashPassword(responsableRayon1.getPassword()));
            this.responsableRayonRepository.save(responsableRayon1);

        }else{
            throw new RuntimeException("user already exist");
        }
        return responsableDto;
    }


}
