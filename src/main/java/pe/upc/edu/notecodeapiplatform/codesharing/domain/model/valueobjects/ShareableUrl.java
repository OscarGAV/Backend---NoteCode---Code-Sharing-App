package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ShareableUrl(@Column(unique = true, nullable = false, length = 8) String urlCode) {

    public ShareableUrl {
        if (urlCode == null || urlCode.isBlank()) {
            urlCode = generate();
        }
    }

    public ShareableUrl() {
        this(generate());
    }

    private static String generate() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
}