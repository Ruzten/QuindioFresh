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
        this.direccion = builder.direccion;
        this.nota = builder.nota;
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
}
