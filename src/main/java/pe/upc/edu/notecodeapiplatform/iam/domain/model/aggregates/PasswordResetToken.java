package pe.upc.edu.notecodeapiplatform.iam.domain.model.aggregates;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pe.upc.edu.notecodeapiplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.Instant;
import java.util.UUID;

@Getter
@Entity
public class PasswordResetToken extends AuditableAbstractAggregateRoot<PasswordResetToken> {
    @Column(unique = true)
    private String email;

    @Column
    private String token;

    @Column
    private Instant expiresAt;

    // ← Cambiar esto
    @Setter
    @Column
    private boolean used;

    protected PasswordResetToken() { /* JPA */ }

    public PasswordResetToken(String email, String token, Instant expiresAt) {
        this.email = email;
        this.token = token;
        this.expiresAt = expiresAt;
        this.used = false;
    }

}
