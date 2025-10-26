package pe.upc.edu.notecodeapiplatform.shared.application.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
