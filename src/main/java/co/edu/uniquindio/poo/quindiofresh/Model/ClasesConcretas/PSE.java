package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

import java.time.Month;

public class PSE implements IprocessPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago exitoso mediante PSE por un monto de "+ monto);
    }
}
