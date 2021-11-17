package exceptions;

public class TooSmallMatrixException extends Exception {
    private static String messageErr = "Matrix size is too small! Dimensions should be >0.";

    public TooSmallMatrixException() {
        super(messageErr);
    }

    public TooSmallMatrixException(String message) {
        super(messageErr + "\n" + message);
        messageErr += " " + message;
    }

    public TooSmallMatrixException(String message, Throwable cause) {
        super(messageErr + "\n" + message, cause);
        messageErr += " " + message;
    }

    public TooSmallMatrixException(Throwable cause) {
        super(messageErr, cause);
    }
}
