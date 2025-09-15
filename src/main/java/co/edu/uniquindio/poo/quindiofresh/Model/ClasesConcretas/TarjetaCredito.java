package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

public class TarjetaCredito implements IprocessPago {

    @Override
    public void procesarPago(double monto){
        System.out.println("Pago exitoso con tarjeta de credito por un monto de "+ monto);
    };
}
