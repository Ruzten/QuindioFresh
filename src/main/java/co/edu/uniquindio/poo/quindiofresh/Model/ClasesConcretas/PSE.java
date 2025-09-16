package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.IprocessPago;

public class PSE implements IprocessPago {
    @Override
    public Boolean procesarPago(double monto) {
        return  false;
    }
}
