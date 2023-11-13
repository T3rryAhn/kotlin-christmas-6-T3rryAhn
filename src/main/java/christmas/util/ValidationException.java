package christmas.util;

public class ValidationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_HEAD = "[ERROR] ";

    public ValidationException(String s) {
        super(ERROR_MESSAGE_HEAD + s);
    }
}
