package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import pe.upc.edu.notecodeapiplatform.shared.application.exceptions.InvalidValueException;

@Embeddable
public record ProgrammingLanguage(String language) {

    public ProgrammingLanguage {
        if (language == null || language.isBlank()) {
            throw new InvalidValueException("Programming language cannot be null or empty");
        }

        // Normalize to lowercase for consistency
        language = language.trim().toLowerCase();

        if (language.length() > 50) {
            throw new InvalidValueException("Programming language name cannot exceed 50 characters");
        }
    }

    public ProgrammingLanguage() {
        this("plaintext");
    }
}