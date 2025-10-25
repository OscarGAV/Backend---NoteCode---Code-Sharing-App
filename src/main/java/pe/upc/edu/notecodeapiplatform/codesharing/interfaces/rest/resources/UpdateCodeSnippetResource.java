package pe.upc.edu.notecodeapiplatform.codesharing.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public record UpdateCodeSnippetResource(
        @Schema(description = "Code content", example = "print('Hello Updated World')")
        String content,

        @Schema(description = "Programming language", example = "python")
        @Size(max = 50, message = "Language name cannot exceed 50 characters")
        String language,

        @Schema(description = "Is snippet public?", example = "false")
        Boolean isPublic
) {
}