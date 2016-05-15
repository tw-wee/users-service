package tw.wee.user.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public class ApiError {
    private String code;
    private String message;
    private List<ApiErrorField> errorFields;

    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void addErrorField(ApiErrorField apiErrorField) {
        if(errorFields ==null){
            errorFields = new ArrayList<ApiErrorField>();
        }
        errorFields.add(apiErrorField);
    }
}
