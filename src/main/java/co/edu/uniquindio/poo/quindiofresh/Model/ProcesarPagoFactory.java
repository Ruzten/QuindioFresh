package co.edu.uniquindio.poo.quindiofresh.Model;

public class ProcesarPagoFactory {
    static IProcesarPago tipoPago(String tipo){
        switch (tipo) {
            case "Tarjeta":
                TarjetaCredito tarjetaCredito = new TarjetaCredito();
                break;
            case "PSE":
                PSE pse = new PSE();
                break;
        }
        return  null;
    }
}
