package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

public class ProcesarPagoFactory {
    public static IprocessPago tipoPago(String tipo){
        switch (tipo) {
            case "Tarjeta":
                TarjetaCredito tarjetaCredito = new TarjetaCredito();
                return  tarjetaCredito;
            case "PSE":
                PSE pse = new PSE();
                return  pse;
        }
        return  null;
    }
}
