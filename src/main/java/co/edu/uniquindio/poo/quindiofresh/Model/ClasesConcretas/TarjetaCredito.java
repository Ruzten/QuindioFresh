package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

public class TarjetaCredito implements IprocessPago {

    @Override
    public Boolean procesarPago(double monto){
        return  true;
    };
}
