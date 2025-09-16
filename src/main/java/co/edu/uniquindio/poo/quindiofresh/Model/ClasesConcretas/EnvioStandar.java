package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Ienvio;

import javax.swing.*;

public class EnvioStandar implements Ienvio {

    @Override
    public double enviar(double totalPedido) {
        double nuevoTotal = totalPedido + 7000;
        JOptionPane.showMessageDialog(null, "El valor de tu pedido junto al envio es de: " + nuevoTotal);
        return nuevoTotal;
    }
}
