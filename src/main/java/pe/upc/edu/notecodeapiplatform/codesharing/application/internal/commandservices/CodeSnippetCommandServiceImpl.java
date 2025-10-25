package pe.upc.edu.notecodeapiplatform.codesharing.application.internal.commandservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.aggregates.CodeSnippet;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.CreateCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.DeleteCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.UpdateCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.services.CodeSnippetCommandService;
import pe.upc.edu.notecodeapiplatform.codesharing.infrastructure.persistence.jpa.repositories.CodeSnippetRepository;
import pe.upc.edu.notecodeapiplatform.shared.application.exceptions.ResourceNotFoundException;

import java.util.Optional;

@Service
public class CodeSnippetCommandServiceImpl implements CodeSnippetCommandService {

    private final CodeSnippetRepository codeSnippetRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeSnippetCommandServiceImpl.class);

    public CodeSnippetCommandServiceImpl(CodeSnippetRepository codeSnippetRepository) {
        this.codeSnippetRepository = codeSnippetRepository;
    }

    @Override
    public Optional<CodeSnippet> handleCreate(CreateCodeSnippetCommand command) {
        LOGGER.info("Starting to process create code snippet command");

        var codeSnippet = new CodeSnippet(command);

        try {
            LOGGER.debug("Saving code snippet to repository");
            codeSnippetRepository.save(codeSnippet);
            LOGGER.info("Code snippet created successfully with ID: {} and share URL: {}",
                    codeSnippet.getId(), codeSnippet.getShareUrl());
        } catch (Exception e) {
            LOGGER.error("Error while saving code snippet: {}", e.getMessage(), e);
            throw new RuntimeException("Error while saving code snippet: " + e.getMessage());
        }

        return Optional.of(codeSnippet);
    }

    @Override
    public Optional<CodeSnippet> handleUpdate(UpdateCodeSnippetCommand command) {
        LOGGER.info("Starting to process update code snippet command for ID: {}", command.snippetId());

        LOGGER.debug("Searching for code snippet with ID: {}", command.snippetId());
        var codeSnippet = codeSnippetRepository.findById(command.snippetId())
                .orElseThrow(() -> {
                    LOGGER.warn("Code snippet with ID {} not found", command.snippetId());
                    return new ResourceNotFoundException("Code snippet with ID " + command.snippetId() + " not found");
                });

        LOGGER.info("Updating code snippet with ID: {}", command.snippetId());
        codeSnippet.update(command);

        try {
            LOGGER.debug("Saving updated code snippet to repository");
            codeSnippetRepository.save(codeSnippet);
            LOGGER.info("Code snippet updated successfully with ID: {}", codeSnippet.getId());
        } catch (Exception e) {
            LOGGER.error("Error while updating code snippet: {}", e.getMessage(), e);
            throw new RuntimeException("Error while updating code snippet: " + e.getMessage());
        }

        return Optional.of(codeSnippet);
    }

    @Override
    public void handleDelete(DeleteCodeSnippetCommand command) {
        LOGGER.info("Starting to process delete code snippet command for ID: {}", command.snippetId());

        LOGGER.debug("Checking if code snippet exists with ID: {}", command.snippetId());
        if (!codeSnippetRepository.existsById(command.snippetId())) {
            throw new ResourceNotFoundException("Code snippet with ID " + command.snippetId() + " not found");
        }

        try {
            LOGGER.debug("Deleting code snippet from repository");
            codeSnippetRepository.deleteById(command.snippetId());
            LOGGER.info("Code snippet deleted successfully with ID: {}", command.snippetId());
        } catch (Exception e) {
            LOGGER.error("Error while deleting code snippet: {}", e.getMessage(), e);
            throw new RuntimeException("Error while deleting code snippet: " + e.getMessage());
        }
    }
}