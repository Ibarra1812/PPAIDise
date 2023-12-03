
public class Cliente {
    private String dni;
    private String nombreCompleto;
    private String nroCelular;
    private InformacionCliente infoCliente;

    public Cliente(String dni, String nombreCompleto, String nroCelular, InformacionCliente infoCliente) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
        this.infoCliente = infoCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    
    public boolean esInformacionCorrecta(){
        if(infoCliente.esValidacion()== true && infoCliente.esInformacionCorrecta()== true ){
            return true;
        }
        return false;
    }
    
    
}
