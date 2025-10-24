package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands;

public record UpdateCodeSnippetCommand(Long snippetId,
                                       String title,
                                       String content,
                                       String language,
                                       String theme,
                                       Long userId,
                                       Boolean isPublic) {
}
