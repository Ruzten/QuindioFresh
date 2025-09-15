package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

public class Producto {
    private String Sku;
    private String nombre;
    private double precio;

    public String getSku() {
        return Sku;
    }

    public void setSku(String sku) {
        Sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
