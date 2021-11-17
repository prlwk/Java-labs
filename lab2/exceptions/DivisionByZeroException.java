package exceptions;

public class DivisionByZeroException extends ArithmeticException {
    private static String messageErr = "Cannot be divided by zero!";

    public DivisionByZeroException() {
        super(messageErr);
    }

    public DivisionByZeroException(String message) {
        super(messageErr + "\n" + message);
        messageErr += "\n" + message;
    }

    @Override
    public String toString() {
        return messageErr;
    }
}
