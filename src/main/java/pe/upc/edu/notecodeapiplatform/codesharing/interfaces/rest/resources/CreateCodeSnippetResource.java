package pe.upc.edu.notecodeapiplatform.codesharing.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record CreateCodeSnippetResource(
        @Schema(description = "Code content", example = "print('Hello World')")
        @NotBlank(message = "Content is mandatory")
        String content,

        @Schema(description = "Programming language", example = "python")
        @NotBlank(message = "Language is mandatory")
        @Size(max = 50, message = "Language name cannot exceed 50 characters")
        String language,

        @Schema(description = "User ID who created the snippet", example = "1")
        Long userId,

        @Schema(description = "Is snippet public?", example = "true")
        Boolean isPublic
) {
}