package pe.upc.edu.notecodeapiplatform.shared.application.exceptions;

import java.io.Serial;

public class InvalidValueException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueException(Throwable cause) {
        super(cause);
    }
}
