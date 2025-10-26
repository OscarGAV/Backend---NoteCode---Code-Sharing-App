package pe.upc.edu.notecodeapiplatform.iam.infrastructure.mailing.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender sender;

    @Value("${spring.mail.from}")
    private String fromEmail;

    public MailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendPasswordResetCode(String to, String code) {
        var msg = new SimpleMailMessage();
        msg.setFrom(fromEmail);
        msg.setTo(to);
        msg.setSubject("Recuperación de contraseña - Código de confirmación");
        msg.setText("Tu código de recuperación es: " + code + "\nEste código expira en 15 minutos.");
        sender.send(msg);
    }
}