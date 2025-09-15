package co.edu.uniquindio.poo.quindiofresh.Model;

public class DetallePedido {
    private Producto producto;
    private double Cantidad;

    private DetallePedido(Producto producto, double Cantidad) {
        this.producto = producto;
        this.Cantidad = Cantidad;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double cantidad) {
        Cantidad = cantidad;
    }

    public double CalcularSubtotal() {
        double total = 0;
        total += producto.getPrecio();
        return  total;
    }


}
