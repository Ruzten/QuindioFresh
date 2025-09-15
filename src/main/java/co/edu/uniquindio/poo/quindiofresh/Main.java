package co.edu.uniquindio.poo.quindiofresh;

import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.CatalogoProducto;

public class Main {
    public static void main(String[] args) {
        CatalogoProducto otraInstancia = CatalogoProducto.getInstance();

        Object productos = otraInstancia.MostrarProductos();

        System.out.println(productos);
    }
}
