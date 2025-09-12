package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import java.util.Date;

public class PedidoBuilder {
    public String id;
    public Date fecha;
    public String direccion = "";
    public String nota = "";

    public PedidoBuilder(String id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public PedidoBuilder withDireccion (String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PedidoBuilder withNota (String nota) {
        this.nota = nota;
        return this;
    }

    public Pedido build() {
        return new Pedido(this);
    }

}
