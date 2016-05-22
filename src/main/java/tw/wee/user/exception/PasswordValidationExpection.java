package tw.wee.user.exception;

public class PasswordValidationExpection extends RuntimeException{
    public PasswordValidationExpection(String message) {
        super(message);
    }
}
