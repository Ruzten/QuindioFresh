package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class Email implements Inotificaciones {

    private static final String REMITENTE = "quindiofresh@gmail.com";
    private static final String CLAVE = "vcah oohb xvox wqbu";

    @Override
    public void notificar(Pedido pedido) {
        System.out.println("notificando bro");
        String MdetallesPedido = "";
        for (DetallePedido detallePedido : pedido.getDetalles() ) {
            MdetallesPedido += detallePedido.toString();
        }

        SesionCliente sesion = SesionCliente.getInstancia();
        Cliente cliente = sesion.getClienteActual();
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
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cliente.getEmail()));
            msg.setSubject("Notificación de pedido!");
            msg.setText("Hola! aqui tienes el resumen de tu pedido" +
                    "\n\n" + MdetallesPedido + "\n-------------------\n" + "total (sin envio): " + pedido.calcularTotal());

            Transport.send(msg);
            System.out.println("✅ Correo enviado a: " + cliente.getEmail());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
