package os.merjanepromotion.util.Observer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import os.merjanepromotion.entity.Promotion;
import os.merjanepromotion.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ObservableImpl implements Observable<Promotion>{
    List<Observer> observers = new ArrayList<>();
    private PromotionRepository promotionRepository;
    @Autowired
    public ObservableImpl(PromotionRepository promotionRepository){
        this.promotionRepository = promotionRepository;
    }
    @Override
    public void subscriber(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(Promotion promotion) {
        for(Observer observer: observers){
            observer.upDate(promotion);
        }
    }

    public void addPromotion(Promotion promotion){
        promotionRepository.save(promotion);
        notifyObserver(promotion);
    }

}
