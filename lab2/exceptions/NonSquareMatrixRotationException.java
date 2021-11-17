package exceptions;

public class NonSquareMatrixRotationException extends Exception {

    private static final String messageErr = "You cannot rotate the non-square matrix!";

    public NonSquareMatrixRotationException() {
        super(messageErr);
    }

    public NonSquareMatrixRotationException(String message) {
        super(messageErr + "\n " + message);
    }

    public NonSquareMatrixRotationException(String message, Throwable cause) {
        super(messageErr + "\n " + message, cause);
    }

    public NonSquareMatrixRotationException(Throwable cause) {
        super(messageErr, cause);
    }

    @Override
    public String toString() {
        return messageErr;
    }
}
