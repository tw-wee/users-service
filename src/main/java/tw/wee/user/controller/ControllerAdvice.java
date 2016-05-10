package tw.wee.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tw.wee.user.exception.ApiError;
import tw.wee.user.exception.InvalidUserException;

import static tw.wee.user.Utils.ErrorCode.INVALID_USER;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidUserException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handle(InvalidUserException exception){
        return new ApiError(INVALID_USER,exception.getMessage());
    }

}
