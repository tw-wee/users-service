package tw.wee.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tw.wee.user.Utils.ErrorCode;
import tw.wee.user.exception.*;

import static java.util.Locale.getDefault;
import static tw.wee.user.Utils.ErrorCode.INVALID_USER;
import static tw.wee.user.Utils.ErrorCode.USER_NOT_EXIST;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @Autowired
    private MessageSource messageSource;

    final static Logger logger = Logger.getLogger(ControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(InvalidUserException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handle(InvalidUserException exception){
        logger.error("The request is invalid ", exception);
        ApiError apiError = new ApiError(INVALID_USER, exception.getMessage());
        if(exception.getMessage() != null){
            handleBindingResult(exception, apiError);
        }
        return apiError;
    }

    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError handle(UserNotExistException exception){
        return new ApiError(USER_NOT_EXIST ,exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(PasswordValidationExpection.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ApiError handle(PasswordValidationExpection exception){
        return new ApiError(ErrorCode.PASSWORD_NOT_RIGHT ,exception.getMessage());
    }

    private void handleBindingResult(InvalidUserException exception, ApiError apiError) {
        for(FieldError error : exception.getBindingResult().getFieldErrors()){
            apiError.addErrorField(new ApiErrorField(error.getField(), messageSource.getMessage(error, getDefault())));
        }
    }
}
