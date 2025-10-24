package pe.upc.edu.notecodeapiplatform.codesharing.domain.services;

import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.aggregates.CodeSnippet;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.CreateCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.DeleteCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.UpdateCodeSnippetCommand;

import java.util.Optional;

public interface CodeSnippetCommandService {
    Optional<CodeSnippet> handle(CreateCodeSnippetCommand command);
    Optional<CodeSnippet> handle(UpdateCodeSnippetCommand command);
    void handle(DeleteCodeSnippetCommand command);
}
