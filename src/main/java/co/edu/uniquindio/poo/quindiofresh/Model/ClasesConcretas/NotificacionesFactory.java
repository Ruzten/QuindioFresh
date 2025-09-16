package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;

public class NotificacionesFactory {
    public static Inotificaciones Notificaciones(String tipo){

        switch (tipo) {
            case "SMS":
                return new SMS();
            case "Email":
                return new Email();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + tipo);
        }
    }
}
