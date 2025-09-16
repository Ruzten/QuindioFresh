package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;

public class SMS implements Inotificaciones {
    SesionCliente sesionCliente = SesionCliente.getInstancia();
    Cliente cliente = sesionCliente.getClienteActual();
    @Override
    public void notificar(Pedido pedido) {
        String MdetallesPedido = "";
        for (DetallePedido detallePedido : pedido.getDetalles() ) {
            MdetallesPedido += detallePedido.toString();
        }
        System.out.println("📱 SMS enviado a " + cliente.getTelefono() + ": " + "Hola! aqui tienes el resumen de tu pedido" +
                "\n\n" + MdetallesPedido);
    }
}
