package pe.upc.edu.notecodeapiplatform.shared.application.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message) {
        super(message);
    }
}
