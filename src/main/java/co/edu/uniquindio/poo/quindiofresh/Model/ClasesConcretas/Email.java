package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class Email implements Inotificaciones {

    private static final String REMITENTE = "quindiofresh@gmail.com";
    private static final String CLAVE = "Quindiofresh2025";

    private String destinatario;
    private String asunto;
    private String mensaje;

    public Email(String destinatario, String asunto, String mensaje) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    @Override
    public void notificar() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CLAVE);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(REMITENTE));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(asunto);
            msg.setText(mensaje);

            Transport.send(msg);
            System.out.println("✅ Correo enviado a: " + destinatario);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
