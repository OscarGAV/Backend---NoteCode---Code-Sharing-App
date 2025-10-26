package pe.upc.edu.notecodeapiplatform.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/debug")
@Tag(name = "Debug Controller", description = "Debugging Endpoints")
public class DebugController {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private String mailPort;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Value("${spring.mail.from}")
    private String mailFrom;

    public DebugController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/mail-config")
    public Map<String, String> getMailConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("host", mailHost);
        config.put("port", mailPort);
        config.put("username", mailUsername);
        config.put("password", mailPassword != null && !mailPassword.isEmpty() ?
                "Configurado (longitud: " + mailPassword.length() + " caracteres)" : "NO CONFIGURADO");
        config.put("passwordStartsWith", mailPassword != null && mailPassword.length() > 3 ?
                mailPassword.substring(0, 3) + "..." : "N/A");
        config.put("from", mailFrom);
        return config;
    }

    @GetMapping("/test-email")
    public Map<String, String> testEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailFrom);
            message.setTo("owoskar123@gmail.com");
            message.setSubject("Test Email - NoteCode");
            message.setText("Este es un email de prueba desde NoteCode API");

            mailSender.send(message);

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Email enviado correctamente");
            response.put("from", mailFrom);
            response.put("to", "owoskar123@gmail.com");
            return response;
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            response.put("exceptionType", e.getClass().getName());
            if (e.getCause() != null) {
                response.put("cause", e.getCause().getMessage());
            }
            return response;
        }
    }
}