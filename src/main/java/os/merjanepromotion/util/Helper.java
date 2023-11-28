package os.merjanepromotion.util;

import java.security.SecureRandom;

public class Helper {
    private static final String Character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String codeGenerater(int num){
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(num);
        for (int i=0; i < num; i++){
            int radomIndex = random.nextInt(Character.length());
            char randomChar = Character.charAt(radomIndex);
            stringBuilder.append(randomChar);
        }
        return  stringBuilder.toString();
    }
}
