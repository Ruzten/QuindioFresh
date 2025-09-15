package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;

public class SMS implements Inotificaciones {

    private String numero;
    private String mensaje;

    public SMS(String numero, String mensaje) {
        this.numero = numero;
        this.mensaje = mensaje;
    }

    @Override
    public void notificar() {
        // Simulación de envío de SMS
        System.out.println("📱 SMS enviado a " + numero + ": " + mensaje);
    }
}
