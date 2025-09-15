package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import java.util.ArrayList;
import java.util.List;

class CatalogoProducto {
    private static CatalogoProducto instance;
    private List<Producto> productos;

    private CatalogoProducto() {
        this.productos = new ArrayList<>();
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
}
