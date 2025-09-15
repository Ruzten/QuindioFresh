package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

public class DetallePedido {
    private Producto producto;
    private double cantidad;

    public DetallePedido(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal () {
        return producto.getPrecio() * cantidad;
    }

}
