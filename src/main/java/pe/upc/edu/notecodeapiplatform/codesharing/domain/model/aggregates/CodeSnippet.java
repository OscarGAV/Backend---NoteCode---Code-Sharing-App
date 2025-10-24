package pe.upc.edu.notecodeapiplatform.codesharing.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.CreateCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.commands.UpdateCodeSnippetCommand;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.valueobjects.*;
import pe.upc.edu.notecodeapiplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class CodeSnippet extends AuditableAbstractAggregateRoot<CodeSnippet> {

    /* PENDING TO VALIDATE IF IS NEEDED A VALUE OBJECT FOR TITLE OR JUST A STRING
    @Embedded
    private SnippetTitle title;*/

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Embedded
    private ProgrammingLanguage language;

    /* PENDING TO VALIDATE IF IS NEEDED
    @Embedded
    private ThemePreference theme;*/

    @Embedded
    private ShareableUrl shareableUrl;

    @Column
    private Long userId;

    @Column(nullable = false)
    private Boolean isPublic;

    public CodeSnippet() {
        // Default constructor for JPA
    }

    public CodeSnippet(CreateCodeSnippetCommand command) {
        /*this.title = new SnippetTitle(command.title());*/
        this.content = command.content();
        this.language = new ProgrammingLanguage(command.language());
        /*this.theme = new ThemePreference(command.theme());*/
        this.shareableUrl = new ShareableUrl();
        this.userId = command.userId();
        this.isPublic = command.isPublic() != null ? command.isPublic() : true;
    }

    public void update(UpdateCodeSnippetCommand command) {
        /* PENDING
        if (command.title() != null && !command.title().isBlank()) {
            this.title = new SnippetTitle(command.title());
        }*/
        if (command.content() != null) {
            this.content = command.content();
        }
        if (command.language() != null && !command.language().isBlank()) {
            this.language = new ProgrammingLanguage(command.language());
        }
        /* PENDING
        if (command.theme() != null && !command.theme().isBlank()) {
            this.theme = new ThemePreference(command.theme());
        }*/
        if (command.isPublic() != null) {
            this.isPublic = command.isPublic();
        }
    }


    public String getShareUrl() {
        return this.shareableUrl.urlCode();
    }
}