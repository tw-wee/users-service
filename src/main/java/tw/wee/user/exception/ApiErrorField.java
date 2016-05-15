package tw.wee.user.exception;

public class ApiErrorField {
    private final String field;
    private final String message;

    public ApiErrorField(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
