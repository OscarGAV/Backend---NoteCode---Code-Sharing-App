package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.valueobjects;

import java.util.UUID;

public record ShareableUrl(String urlCode) {

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