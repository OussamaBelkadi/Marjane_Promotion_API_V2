package os.merjanepromotion.services;

public interface AuthentificationService <D> {
//    D login(D D) throws CustomException;
    boolean logout();
    D register(D d);
    D login(D d);

}
