package pe.upc.edu.notecodeapiplatform.shared.application.exceptions;

import java.io.Serial;

public class InvalidValueException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidValueException(String message) {
        super(message);
    }
}
