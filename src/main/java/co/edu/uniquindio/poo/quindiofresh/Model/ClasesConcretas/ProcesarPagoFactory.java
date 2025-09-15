package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

public class ProcesarPagoFactory {
    static IprocessPago tipoPago(String tipo){
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
