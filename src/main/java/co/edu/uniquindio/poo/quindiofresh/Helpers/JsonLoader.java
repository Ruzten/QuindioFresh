package co.edu.uniquindio.poo.quindiofresh.Helpers;

import co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas.Producto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    public static <T> List<T> CargarProductos(String fileName, Class<T> clazz) {
        try (var inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            try (var reader = new InputStreamReader(inputStream)) {
                Gson gson = new Gson();
                Type listType = TypeToken.getParameterized(List.class, clazz).getType();
                return gson.fromJson(reader, listType);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
