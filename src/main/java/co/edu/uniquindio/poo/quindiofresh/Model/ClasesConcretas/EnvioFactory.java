package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

import co.edu.uniquindio.poo.quindiofresh.Model.Interfaces.Ienvio;

public class EnvioFactory {
    static Ienvio CrearTipoEnvio (String tipo){
        switch (tipo){
            case  "Standar":
                EnvioStandar envioStandar = new EnvioStandar();
                break;
            case "Express":
                EnvioExpress envioExpress = new EnvioExpress();
        }
        return  null;
    }
}
