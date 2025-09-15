package co.edu.uniquindio.poo.quindiofresh.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoBuilder {
    public String codigo;
    public LocalDate Fecha;
    private Client client;
    private ArrayList<DetallePedido> detalles;
    public String direccion;
    public String nota;
    public String CodigoDescuento;

    public PedidoBuilder (String codigo, LocalDate Fecha, Client client, ArrayList detalles) {
        this.codigo = codigo;
        this.Fecha = Fecha;
        this.client = client;
        this.detalles = detalles;
    }

    public PedidoBuilder WithDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PedidoBuilder WithNota(String nota) {
        this.nota = nota;
        return this;
    }

    public PedidoBuilder WithCodigoDescuento(String codigoDescuento) {
        this.codigo = codigoDescuento;
        return this;
    }



    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetallePedido> detalles) {
        this.detalles = detalles;
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

    public String getCodigoDescuento() {
        return CodigoDescuento;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        CodigoDescuento = codigoDescuento;
    }
}
