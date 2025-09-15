package co.edu.uniquindio.poo.quindiofresh.Model;

public class EnvioFactory {
    static IEnvio CrearTipoEnvio (String tipo){
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
