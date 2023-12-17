package registrationsystem;

import UsersOfLibrary.User;

import java.util.regex.Pattern;

public interface DataConstraints {
    default boolean checkName(String username){

        if(username==null||username.length()<5) {
            return false;
        }
        for ( char c: username.toCharArray()) {
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            {
                continue;
            }
            return false;
        }
        return true;
    }
    default boolean checkPasswordIsStrong(String password){
        if(password==null){
            return false;
        }
        if(password.length()<8){
            return false;
        }
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
        {
            return false;
        }
        for (User user :
                User.users  ) {
            if(email.equals(user.getEmail()))
            {
                return false;
            }
        }
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
}
