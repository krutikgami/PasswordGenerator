import java.util.ArrayList;
import java.util.Random;

public class PasswordGeneratorL {
    public static final String LOWERCASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_-+=[]{}|;:,.<>/?";

    private final Random random;

    public PasswordGeneratorL(){
        random = new Random();
    }

    public String generatePassword(int length,boolean includeUppercase,boolean includeLowercase,boolean includeNumbers,boolean includeSpecialSymbols){
        StringBuilder passwordBuilder = new StringBuilder();

        String validChar = "";
        if (includeUppercase) validChar+=UPPERCASE_CHAR;
        if (includeLowercase) validChar+=LOWERCASE_CHAR;
        if (includeNumbers) validChar+=NUMBERS;
        if (includeSpecialSymbols) validChar+= SPECIAL_SYMBOLS;

        for (int i=0;i<length;i++){
            int randomIndex =random.nextInt(validChar.length());

            char randomChar = validChar.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}