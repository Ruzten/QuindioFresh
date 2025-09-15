package co.edu.uniquindio.poo.quindiofresh.Model;

public class NotificacionesFactory {
    static Inotificaciones Notificaciones(String tipo){
        switch (tipo) {
            case "SMS":
                SMS MensajaeSms = new SMS();
                break;
            case "Email":
                Email MensajeEmail = new Email();
        }
        return  null;
    }
}
