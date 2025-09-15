package co.edu.uniquindio.poo.quindiofresh;

import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SesionCliente sesion = SesionCliente.getInstancia();
        CatalogoProducto catalogoProducto = CatalogoProducto.getInstance();
        Icon icono = new ImageIcon("src/main/resources/co/edu/uniquindio/poo/quindiofresh/QuindioFresh.png");

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda virtual QuindioFresh!", "QuindioFresh // Registro", 1, icono);
        String idCliente = JOptionPane.showInputDialog("Por favor ingresa tu cedula");
        String nombreCliente = JOptionPane.showInputDialog("Por favor ingresa tu nombre");
        String emailCliente = JOptionPane.showInputDialog("Por favor ingresa tu email");
        String telefonoCliente = JOptionPane.showInputDialog("Por favor ingresa tu numero de telefono");
        Cliente cliente = new Cliente(idCliente, nombreCliente, emailCliente, telefonoCliente);
        sesion.registrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "¡Registro exitoso para " + sesion.getClienteActual().getNombre() + "!");

        JOptionPane.showMessageDialog(null, "Ahora, vamos a crear tu pedido.", "QuindioFresh // Pedido", 1);

        List<Producto> productosDisponibles = catalogoProducto.MostrarTodosProductos();
        String mensajeProductos = "Productos disponibles:\n";
        for (Producto p : productosDisponibles) {
            mensajeProductos += "SKU: " + p.getSku() + ", Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + "\n";
        }

        String skuPedido = JOptionPane.showInputDialog(null, mensajeProductos + "\nIngresa el SKU del producto que deseas comprar:", "Seleccionar Producto", JOptionPane.QUESTION_MESSAGE);
        String cantidadStr = JOptionPane.showInputDialog("Ingresa la cantidad:");

        if (skuPedido == null || cantidadStr == null) {
            JOptionPane.showMessageDialog(null, "Creación de pedido cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Producto productoSeleccionado = catalogoProducto.buscarProductoPorSKU(skuPedido);
        double cantidad = Double.parseDouble(cantidadStr);

        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DetallePedido detalle = new DetallePedido(productoSeleccionado, cantidad);

        String direccionEnvio = JOptionPane.showInputDialog("Ingresa tu dirección de envío (opcional):");
        String notas = JOptionPane.showInputDialog("Ingresa notas especiales para la entrega (opcional):");
        String codigoDescuento = JOptionPane.showInputDialog("Ingresa un código de descuento (opcional):");


        String idPedido = "PED" + System.currentTimeMillis();
        PedidoBuilder builder = new PedidoBuilder(idPedido, new Date(), sesion.getClienteActual());
        builder.withDetalle(detalle);

        if (direccionEnvio != null && !direccionEnvio.isEmpty()) {
            builder.withDireccion(direccionEnvio);
        }
        if (notas != null && !notas.isEmpty()) {
            builder.withNota(notas);
        }
        if (codigoDescuento != null && !codigoDescuento.isEmpty()) {
            builder.withCodigoDescuento(codigoDescuento);
        }

        Pedido pedido = builder.build();

        JOptionPane.showMessageDialog(null, "¡Pedido creado con éxito!\nID del pedido: " + pedido.getId(), "Pedido Creado", JOptionPane.INFORMATION_MESSAGE);





        List<Producto> producto = catalogoProducto.MostrarTodosProductos();
        Producto producto1 = producto.get(0);

        System.out.println(producto1);

        Producto newProducto = new Producto("","Leche", 2400);

        Object ProductoUpdate = catalogoProducto.UpdateProducto("LECHE001", newProducto);

        System.out.println(ProductoUpdate);
    }
}
