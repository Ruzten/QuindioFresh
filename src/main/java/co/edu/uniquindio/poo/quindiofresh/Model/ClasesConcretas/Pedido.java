package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String id;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<DetallePedido> detalles;
    private String direccion;
    private String nota;
    private String codigoDescuento;

    protected Pedido(PedidoBuilder builder) {
        this.id = builder.id;
        this.fecha = builder.fecha;
        this.cliente = builder.cliente;
        this.detalles = builder.detalles;
        this.direccion = builder.direccion;
        this.nota = builder.nota;
        this.codigoDescuento = builder.codigoDescuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDetalles(ArrayList<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public double calcularTotal () {
        double total = 0;
        for (DetallePedido detallePedido : detalles) {
            total += detallePedido.calcularSubtotal();
        }
        return total;
    }

    public ArrayList<DetallePedido> getDetalles() {
        return detalles;
    }
}
