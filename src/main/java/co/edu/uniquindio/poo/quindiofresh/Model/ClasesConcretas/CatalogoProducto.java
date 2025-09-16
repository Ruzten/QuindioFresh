package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Helpers.JsonLoader;

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

    public void CreateProduct(Producto producto) {
        this.productos.add(producto);
    }

    public Producto DeleteProduct(String id) {
        List<Producto> NewProduct = new ArrayList<>(this.productos);
        for(Producto p : NewProduct){
           if(p.getSku().equals(id)){
               this.productos.remove(p);
               return p;
           }
        }
        return null;
    }

    public Producto buscarProductoPorSKU(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null; // Si el bucle termina y no se encontró, retorna null.
    }

    public List<Producto> getAllProduct() {
        return productos;
    }

    public Producto getProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public Producto UpdateProducto(String id, Producto producto){
        List<Producto> updateProduct = new ArrayList<>(this.productos);
        for(Producto p : updateProduct){
            if(p.getSku().equals(id)){
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
            }
            return p;
        }
        return null;
    }
}
