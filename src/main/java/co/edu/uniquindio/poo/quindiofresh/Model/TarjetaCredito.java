package co.edu.uniquindio.poo.quindiofresh.Model;

public class TarjetaCredito implements IProcesarPago{

    @Override
    public void ProcesarPago(double monto) {
        System.out.println("Pago exitoso");
    }
}
