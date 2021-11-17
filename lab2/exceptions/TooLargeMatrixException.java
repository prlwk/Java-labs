package exceptions;

public class TooLargeMatrixException extends Exception {
    private static String messageErr = "Matrix size is too large! Dimensions should be <=1.000.000.";

    public TooLargeMatrixException() {
        super(messageErr);
    }

    public TooLargeMatrixException(String message) {
        super(messageErr + "\n" + message);
        messageErr += " " + message;
    }

    public TooLargeMatrixException(String message, Throwable cause) {
        super(messageErr + "\n" + message, cause);
        messageErr += " " + message;
    }

    public TooLargeMatrixException(Throwable cause) {
        super(messageErr, cause);
    }

    @Override
    public String toString() {
        return messageErr;
    }
}
