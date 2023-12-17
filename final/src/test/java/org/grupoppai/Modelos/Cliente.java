package org.grupoppai.Modelos;


import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombreCompleto;
    private String nroCelular;
    @OneToMany
    private List<InformacionCliente> infoCliente;

    public Cliente(String dni, String nombreCompleto, String nroCelular, List<InformacionCliente> infoCliente) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
        this.infoCliente = infoCliente;
    }

    public Cliente() {

    }

    //Metodo encargado de obtener el nombre completo del cliente.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //Metodo encargado de corroborar que sea una validacion valida y que el dato a validar sea correcto.
    /*
    public boolean esInformacionCorrecta(String datoValidacion){
        
        //Condicionar encargado de corroborar sea una validacion valida y la informacion sea correcta. 
        return (infoCliente.esValidacion(infoCliente.getValidacion()) && infoCliente.esInformacionCorrecta(datoValidacion));

    }
     */

    public boolean esInformacionCorrecta (String val, String datoValidacion) {
        for (InformacionCliente info: infoCliente) {
            if (info.esValidacion(val)) {
                return info.esInformacionCorrecta(datoValidacion);
            }
        }
        return false;
    }
}
