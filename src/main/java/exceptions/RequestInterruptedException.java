package exceptions;

public class RequestInterruptedException extends Exception {
    public RequestInterruptedException(String message) {
        super(message);
    }

    public RequestInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestInterruptedException(Throwable cause) {
        super(cause);
    }

    public RequestInterruptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}