package exceptions;

public class NonExistentFileException extends Exception {
    private static String messageErr = "File with this name does not exist!";

    public NonExistentFileException() {
        super(messageErr);
    }

    public NonExistentFileException(String fileName) {
        super(messageErr + " Specified filename: " + fileName);
        messageErr += " Specified filename: " + fileName;
    }

    public NonExistentFileException(String fileName, Throwable cause) {
        super(messageErr + "specified filename: " + fileName, cause);
        messageErr += " Specified filename: " + fileName;
    }

    public NonExistentFileException(Throwable cause) {
        super(messageErr, cause);
    }

    @Override
    public String toString() {
        return messageErr;
    }
}
