package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands;

public record CreateCodeSnippetCommand(
        String title,
        String content,
        String language,
        String theme,
        Long userId,
        Boolean isPublic
) {
}