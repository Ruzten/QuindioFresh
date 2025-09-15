package co.edu.uniquindio.poo.quindiofresh;

import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.CatalogoProducto;
import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CatalogoProducto otraInstancia = CatalogoProducto.getInstance();

        List<Producto> producto = otraInstancia.MostrarTodosProductos();
        Producto producto1 = producto.get(0);

        System.out.println(producto1);

        Producto newProducto = new Producto("","Leche", 2400);

        Object ProductoUpdate = otraInstancia.UpdateProducto("LECHE001", newProducto);

        System.out.println(ProductoUpdate);
    }
}
