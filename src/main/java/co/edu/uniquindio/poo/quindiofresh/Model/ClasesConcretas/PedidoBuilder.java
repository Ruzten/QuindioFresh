package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import java.util.ArrayList;
import java.util.Date;

public class PedidoBuilder {
    public String id;
    public Date fecha;
    public Cliente cliente;
    public ArrayList<DetallePedido> detalles;
    public String direccion = "";
    public String nota = "";
    public String codigoDescuento = "";

    public PedidoBuilder(String id, Date fecha, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public PedidoBuilder withDireccion (String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PedidoBuilder withNota (String nota) {
        this.nota = nota;
        return this;
    }

    public PedidoBuilder withCodigoDescuento (String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
        return this;
    }

    public ArrayList<DetallePedido> getDetallesPedido() {
        return detalles;
    }


    public Pedido build() {
        return new Pedido(this);
    }



}
