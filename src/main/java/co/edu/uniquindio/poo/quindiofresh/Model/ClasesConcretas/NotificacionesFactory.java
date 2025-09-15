package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;

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
