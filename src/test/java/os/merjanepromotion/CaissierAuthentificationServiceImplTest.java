package os.merjanepromotion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import os.merjanepromotion.dto.CaissierDto;
import os.merjanepromotion.entity.Caissier;
import os.merjanepromotion.repository.CaissierAuthentificationRespository;
import os.merjanepromotion.services.impl.CaissierAuthentificationServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CaissierAuthentificationServiceImplTest {

    @InjectMocks
    private CaissierAuthentificationServiceImpl caissierAuthService;

    @Mock
    private CaissierAuthentificationRespository caissierAuthentificationRespository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        CaissierDto caissierDto = new CaissierDto();
        caissierDto.setUsername("testuser");
        caissierDto.setPassword("testpassword");

        Caissier caissierEntity = new Caissier();
        caissierEntity.setUsername("testuser");
        caissierEntity.setPassword("hashedpassword");

        when(caissierAuthentificationRespository.save(any(Caissier.class))).thenReturn(caissierEntity);

        CaissierDto registeredCaissier = caissierAuthService.register(caissierDto);

        assertNotNull(registeredCaissier);
        assertEquals("testuser", registeredCaissier.getUsername());
    }
}
