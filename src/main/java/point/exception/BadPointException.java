package point.exception;

public class BadPointException extends Exception{
    public BadPointException() {
    }

    public BadPointException(String message) {
        super(message);
    }

    public BadPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPointException(Throwable cause) {
        super(cause);
    }

    public BadPointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
