package co.edu.uniquindio.poo.quindiofresh;

import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.*;
import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Ienvio;
import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Inotificaciones;
import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

import javax.swing.*;
import java.util.Date;
import java.util.List;

import static co.edu.uniquindio.poo.quindiofresh.Middleware.validadorDatos.*;
import static co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.ProcesarPagoFactory.tipoPago;

public class Main {
    public static void main(String[] args) {

        SesionCliente sesion = SesionCliente.getInstancia();
        CatalogoProducto catalogoProducto = CatalogoProducto.getInstance();
        Icon icono = new ImageIcon("src/main/resources/co/edu/uniquindio/poo/quindiofresh/QuindioFresh.png");

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda virtual QuindioFresh!", "QuindioFresh // Registro", 1, icono);
        String idCliente = validatorNumber(null, "Cedula");
        String nombreCliente = validatortext(null, "nombre");
        String emailCliente = validatorEmail(null);
        String telefonoCliente = validatorNumber(null, "telefono");
        Cliente cliente = new Cliente(idCliente, nombreCliente, emailCliente, telefonoCliente);
        sesion.registrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "¡Registro exitoso para " + sesion.getClienteActual().getNombre() + "!");
        System.out.println(sesion.getClienteActual().toString());

        JOptionPane.showMessageDialog(null, "Ahora, vamos a crear tu pedido.", "QuindioFresh // Pedido", 1);

        String idPedido = "PED" + System.currentTimeMillis();
        PedidoBuilder builder = new PedidoBuilder(idPedido, new Date(), sesion.getClienteActual());

        boolean seguirComprando = true;

        while (seguirComprando){
            List<Producto> productosDisponibles = catalogoProducto.getAllProduct();
            String mensajeProductos = "Productos disponibles:\n";
            for (Producto p : productosDisponibles) {
                mensajeProductos += "SKU: " + p.getSku() + ", Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + "\n";
            }

            String skuPedido = JOptionPane.showInputDialog(null, mensajeProductos + "\nIngresa el SKU del producto que deseas comprar:", "Seleccionar Producto", JOptionPane.QUESTION_MESSAGE);

            if (skuPedido == null) {
                JOptionPane.showMessageDialog(null, "Creación de pedido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Producto productoSeleccionado = catalogoProducto.buscarProductoPorSKU(skuPedido);

            if (productoSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String cantidadStr = validatorCantidad(null);
            if (cantidadStr == null) {
                JOptionPane.showMessageDialog(null, "Creación de pedido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            double cantidad = Double.parseDouble(cantidadStr);

            DetallePedido detalle = new DetallePedido(productoSeleccionado, cantidad);
            builder.agregarDetalle(detalle);

            String[] opciones = {"Seguir comprando", "Listo"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Deseas agregar otro producto?", "Agregar Producto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            System.out.println(detalle.toString());

            if (eleccion == 1) {
                seguirComprando = false;
            }
        }

        System.out.println(builder.toString());

        String notas = JOptionPane.showInputDialog("Ingresa notas especiales para la entrega (opcional):");
        String codigoDescuento = JOptionPane.showInputDialog("Ingresa un código de descuento (opcional):");

        String[] opciones2 = {"Estandar", "Express"};
        int eleccionEnvio = JOptionPane.showOptionDialog(null, "¿Que tipo de envio prefiere?\nEstandar: 7.000 pesos\nExpress: 15.000 pesos", "TipoEnvio",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0]);
        String direccionEnvio = validatortext(null, "dirección de envío: ");

        String tipoEnvioSelecc = opciones2[eleccionEnvio];
        Ienvio procesarEnvio = EnvioFactory.CrearTipoEnvio(tipoEnvioSelecc);
        double totalPagar = procesarEnvio.enviar(builder.calcularTotal());

        if (direccionEnvio != null && !direccionEnvio.isEmpty()) {
            builder.withDireccion(direccionEnvio);
        }
        if (notas != null && !notas.isEmpty()) {
            builder.withNota(notas);
        }
        if (codigoDescuento != null && !codigoDescuento.isEmpty()) {
            builder.withCodigoDescuento(codigoDescuento);
        }

        JOptionPane.showMessageDialog(null, "Hora del pago!");
        boolean pagoExitoso = false;
        while (!pagoExitoso) {
            String[] opcionesPago = {"Tarjeta", "PSE"};
            String SeleccionarPago = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona tu método de pago:",
                    "Método de Pago",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesPago,
                    opcionesPago[0]
            );

            if (SeleccionarPago == null) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas cancelar el pedido?", "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Proceso de pedido cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else {
                try {
                    IprocessPago procesador = ProcesarPagoFactory.tipoPago(SeleccionarPago);
                    if (SeleccionarPago.equals("Tarjeta")) {
                        JOptionPane.showInputDialog("Ingresa el número de tarjeta:");
                        JOptionPane.showInputDialog("Ingresa el nombre del titular:");
                        JOptionPane.showInputDialog("Ingresa la fecha de vencimiento (MM/AA):");
                        JOptionPane.showInputDialog("Ingresa el código de seguridad (CVV):");
                    } else if (SeleccionarPago.equals("PSE")) {
                        JOptionPane.showInputDialog("Ingresa el banco:");
                        JOptionPane.showInputDialog("Ingresa el número de cuenta:");
                    }

                    double subtotalPedido = totalPagar;
                    if (builder.getDetallesPedido() != null) {
                        for (DetallePedido d : builder.getDetallesPedido()) {
                            subtotalPedido += d.calcularSubtotal();
                        }
                    }

                    System.out.println("Subtotal: " + procesador);
                    boolean mensaje = procesador.procesarPago(subtotalPedido);

                    if (mensaje) {
                        JOptionPane.showMessageDialog(null, "Pago realizado\npor un valor de: " + totalPagar, "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
                        pagoExitoso = true;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Pago rechazado. Por favor, intenta de nuevo.", "Pago Rechazado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }


        Pedido pedido = builder.build();
        sesion.getClienteActual().agregarPedido(pedido);
        System.out.println(sesion.getClienteActual().toString());

        JOptionPane.showMessageDialog(null, "¡Pedido creado con éxito!\nID del pedido: " + pedido.getId(), "Pedido Creado", JOptionPane.INFORMATION_MESSAGE);

        String[] opcionesNotificacion = {"Email", "SMS"};
        int eleccionNotificacion = JOptionPane.showOptionDialog(
                null,
                "¿Cómo deseas recibir la notificación de tu pedido?",
                "Notificación",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesNotificacion,
                opcionesNotificacion[0]
        );

        if (eleccionNotificacion != JOptionPane.CLOSED_OPTION) {
            String tipoNotificacion = opcionesNotificacion[eleccionNotificacion];
            Inotificaciones notificador = NotificacionesFactory.Notificaciones(tipoNotificacion);

            if (notificador != null) {
                notificador.notificar(pedido);
            }
        }
        JOptionPane.showMessageDialog(null, "Ya has sido notificado! Revisalo :D");
        JOptionPane.showMessageDialog(null, "Gracias por elegir QuindioFresh <3");
    }
}