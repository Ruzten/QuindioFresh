package co.edu.uniquindio.poo.quindiofresh.Model;

public class SMS implements Inotificaciones{
    @Override
    public void EnviarMensaje(String mensaje) {
        System.out.println("SMS enviado");
    }
}
