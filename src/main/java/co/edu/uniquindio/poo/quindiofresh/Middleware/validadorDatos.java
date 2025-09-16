package co.edu.uniquindio.poo.quindiofresh.Middleware;

import javax.swing.*;

import java.awt.*;

import static java.util.regex.Pattern.matches;

public class validadorDatos {
    public static String validatortext (Component parent) {
        while (true) {
            String input = JOptionPane.showInputDialog(parent, "Por favor ingresa tu nombre: ");
            if (input == null) return null;
            input = input.trim();
            if (input.matches("(?i)^[a-záéíóúñü\\s]{2,}$")) {
                return input;
            }
            JOptionPane.showMessageDialog(parent,
                    "Nombre inválido. Ingresa solo letras y espacios (mínimo 2 caracteres).",
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

    public static String validatorphone (Component parent){
        while (true) {
            String input = JOptionPane.showInputDialog(parent, "Por favor ingresa tu número de teléfono");
            if (input == null) return null;
            input = input.trim();
            if (input.matches("^[0-9]{7,15}$")) { // solo dígitos, longitud razonable
                return input;
            }
            JOptionPane.showMessageDialog(parent, "Teléfono inválido. Debe contener solo dígitos, (7 a 15).", "Validación", JOptionPane.ERROR_MESSAGE);
        }

    }
}
