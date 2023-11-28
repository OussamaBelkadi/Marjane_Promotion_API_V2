package os.merjanepromotion.util.Observer;


import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.entity.ResponsableRayon;
import os.merjanepromotion.util.EmailProvider.EmailProvider;
@Configuration
@Setter
public class ResponsableObserver implements Observer<Promotion>{
    private ResponsableRayon responsableRayon;


    @Override
    public void upDate(Promotion promotion) {
        System.out.println("responsableRayon.toString()");
//        EmailProvider.sendMail("Une nouvel promotion ajouter", "Promotion Marjane", responsableRayon.getEmail());
//        System.out.println("all is good");
    }
}
