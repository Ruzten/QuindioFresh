package co.edu.uniquindio.poo.quindiofresh.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private String codigo;
    private LocalDate Fecha;
    private Client client;
    private ArrayList<DetallePedido> detalles;
    private String direccion;
    private String nota;
    private String CodigoDescuento;

    Pedido(PedidoBuilder builder) {
        this.codigo = builder.codigo;
        this.Fecha = builder.Fecha;
        this.client = builder.getClient();
        this.detalles = builder.getDetalles();
        this.direccion = builder.direccion;
        this.nota = builder.nota;
        this.CodigoDescuento = builder.CodigoDescuento;
    }


}
