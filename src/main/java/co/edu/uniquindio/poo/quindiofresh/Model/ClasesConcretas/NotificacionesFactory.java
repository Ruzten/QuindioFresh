package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;

public class NotificacionesFactory {
    static Inotificaciones Notificaciones(String tipo, String destinatario, String asunto, String mensaje, String numero, String mensajeSMS){

        switch (tipo) {
            case "SMS":
                SMS MensajaeSms = new SMS(numero, mensajeSMS);
                break;
            case "Email":
                Email MensajeEmail = new Email(destinatario, asunto, mensaje);
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + tipo);
        }
        return  null;
    }
}
