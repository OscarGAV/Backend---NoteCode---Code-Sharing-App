package pe.upc.edu.notecodeapiplatform.iam.infrastructure.persistence.jpa.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.edu.notecodeapiplatform.iam.domain.model.aggregates.PasswordResetToken;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByEmailAndTokenAndUsedFalse(String email, String token);
    @Transactional
    void deleteAllByExpiresAtBefore(Instant time);
}
