package registrationsystem;

import java.util.regex.Pattern;

import static com.example.libirary_.MainClass.emailsTrie;
import static com.example.libirary_.MainClass.namesTrie;

public interface DataConstraints {
    default boolean checkName(String username){

        if(username==null||username.length()<5)
            return false;

        if(namesTrie.search(username))
            return false;
        if(username.length()>15)
            return false;
        return !username.contains(" ");
    }
    default boolean checkPasswordIsStrong(String password){

        if(password==null)
            return false;

        if(password.length()<8)
            return false;

        boolean isFindChar =false,isFindSymbolOrNumber =false;
        for (char c:password.toCharArray()) {
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            {
                isFindChar=true;
            }else if(c=='\t'){
                return false;
            }else {
                isFindSymbolOrNumber =true;
            }
        }
        if(isFindChar&&isFindSymbolOrNumber) {
            return true;
        }
        return false;
    }

    default boolean isValidEmail(String email) {

        if(email==null)
            return false;

        if(emailsTrie.search(email))
            return false;

        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        return pattern.matcher(email).matches();
    }
}
