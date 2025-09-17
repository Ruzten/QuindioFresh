package co.edu.uniquindio.poo.quindiofresh.Middleware;

import javax.swing.*;

import java.awt.*;

import static java.util.regex.Pattern.matches;

public class validadorDatos {
    public static String validatortext (Component parent, String value) {
        while (true) {
            String input = JOptionPane.showInputDialog(parent, "Por favor ingresa tu "+value+ ": ");
            if (input.isEmpty()) return null;
            input = input.trim();
            if (input.matches("(?i)^[a-záéíóúñü\\s]{2,}$")) {
                return input;
            }
            JOptionPane.showMessageDialog(parent,
                    "Información inválida. Ingresa solo letras" +
                            ".",
                    "Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String validatorEmail(Component parent){
        while(true){
            String input = JOptionPane.showInputDialog(parent, "Por favor ingresa tu correo: ");
            if(input == null) return null;
            input = input.trim();
            if(input.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}$")){
                return input;
            }

            JOptionPane.showMessageDialog(parent, "Email invalido. Ingrese el formato correcto de email (@)", "VALIDACION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String validatorNumber (Component parent, String value){
        while (true) {
            String input = JOptionPane.showInputDialog(parent, "Por favor ingresa tu número de "+value);
            if (input == null) return null;
            input = input.trim();
            if (input.matches("^[0-9]{7,15}$")) {
                return input;
            }
            JOptionPane.showMessageDialog(parent, "Información invaliad. Debe contener solo dígitos, (7 a 15).", "Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String validatorCantidad(Component parent){
        while(true){
            String input = JOptionPane.showInputDialog(parent, "Ingresa la cantidad:", "Cantidad Producto");
            if(input == null) return null;
            input =  input.trim();

            int number = Integer.parseInt(input);
            if(number > 0){
                return input;
            }

            JOptionPane.showMessageDialog(parent, "Informacion invalida. Debe ser un número y mayor que 0", "Validacion", JOptionPane.ERROR_MESSAGE);
        }
    }

}
