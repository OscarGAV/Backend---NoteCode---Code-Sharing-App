package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import pe.upc.edu.notecodeapiplatform.shared.application.exceptions.InvalidValueException;

@Embeddable
public record SnippetContent(@Column(columnDefinition = "TEXT", nullable = false) String content) {

    private static final int MAX_CONTENT_LENGTH = 500000; // 500KB approx

    public SnippetContent {
        if (content == null || content.isBlank()) {
            throw new InvalidValueException("Snippet content cannot be null or empty");
        }

        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new InvalidValueException("Snippet content exceeds maximum length of " + MAX_CONTENT_LENGTH + " characters");
        }
    }
}