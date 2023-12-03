package Modelos;


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
    
    //Metodo encargado de obtener el nombre completo del cliente.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //Metodo encargado de corroborar que sea una validacion valida y que el dato a validar sea correcto.
    public boolean esInformacionCorrecta(String datoValidacion){
        
        //Condicionar encargado de corroborar sea una validacion valida y la informacion sea correcta. 
        if(infoCliente.esValidacion(infoCliente.getValidacion())== true && infoCliente.esInformacionCorrecta(datoValidacion)== true ){
            return true;
        }
        return false;
    }
    
    
}
