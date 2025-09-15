package co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;

public class SesionCliente {
    private static SesionCliente instancia;
    private Cliente clienteActual;

    private SesionCliente () {}

    public static SesionCliente getInstancia() {
        if (instancia == null) {
            instancia = new SesionCliente();
        }
        return instancia;
    }

    public void registrarCliente(Cliente cliente) {
        this.clienteActual = cliente;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public boolean hayClienteSeleccionado() {
        return clienteActual != null;
    }
}

