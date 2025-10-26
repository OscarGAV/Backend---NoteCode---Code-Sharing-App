package pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PasswordResetRequestResource(
        @NotBlank(message = "El email es requerido")
        @Email(message = "Formato de email inválido")
        String email
) {}