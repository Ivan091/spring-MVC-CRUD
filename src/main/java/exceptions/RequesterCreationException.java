package exceptions;

public class RequesterCreationException extends RequestInterruptedException {
    public RequesterCreationException() {
    }

    public RequesterCreationException(String message) {
        super(message);
    }

    public RequesterCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequesterCreationException(Throwable cause) {
        super(cause);
    }

    public RequesterCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
