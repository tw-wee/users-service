package tw.wee.user.exception;

import org.springframework.validation.BindingResult;

public class InvalidUserException extends RuntimeException {

    private final BindingResult bindingResult;

    public InvalidUserException(String msg, BindingResult bindingResult) {
        super(msg);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
