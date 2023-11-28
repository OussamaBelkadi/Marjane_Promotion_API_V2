package os.merjanepromotion.util.Observer;

public interface Observable <E>{
    void subscriber(Observer observer);
    void unsubscribe(Observer  observer);
    void notifyObserver(E e);
}
