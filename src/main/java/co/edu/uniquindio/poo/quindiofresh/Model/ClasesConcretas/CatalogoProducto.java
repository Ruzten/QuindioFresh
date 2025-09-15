package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Helpers.JsonLoader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProducto {
    private static CatalogoProducto instance;
    private List<Producto> productos;

    private CatalogoProducto() {
        this.productos = JsonLoader.CargarProductos("Productos.json",  Producto.class);
    }

    public static CatalogoProducto getInstance() {
        if (instance == null) {
            instance = new CatalogoProducto();
        }
        return instance;
    }

    public double getPrecio(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equals(sku)) {
                return p.getPrecio();
            }
        }
        return 0.0;
    }

    public List<Producto> MostrarProductos() {
        return productos;
    }
}
