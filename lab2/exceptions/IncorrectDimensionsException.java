package exceptions;

public class IncorrectDimensionsException extends Exception {

    public IncorrectDimensionsException(String message) {
        super(message);
    }

    public IncorrectDimensionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDimensionsException(Throwable cause) {
        super(cause);
    }
}
