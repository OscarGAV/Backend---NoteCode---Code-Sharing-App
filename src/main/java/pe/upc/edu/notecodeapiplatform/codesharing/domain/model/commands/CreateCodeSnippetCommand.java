package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands;

public record CreateCodeSnippetCommand(
        String content,
        String language,
        Long userId,
        Boolean isPublic
) {
}