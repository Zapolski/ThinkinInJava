package by.zapolski.annotations;

import java.util.List;

public class PasswordUtils {
    @UseCase(id=47,descrition = "Password must contain at leas one numeric")
    public boolean validatePasword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id=49, descrition = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password){
        return prevPasswords.contains(password);
    }

}
