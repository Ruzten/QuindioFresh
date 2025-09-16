package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Ienvio;

public class EnvioFactory {
    public static Ienvio CrearTipoEnvio (String tipo){
        switch (tipo) {
            case "Estandar":
                return new EnvioStandar();
            case "Express":
                return new EnvioExpress();
            default:
                throw new IllegalArgumentException("Tipo de envío no soportado: " + tipo);
        }
    }
}
