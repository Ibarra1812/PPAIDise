package Modelos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OpcionLlamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreOpcionLlamada;
    private int nroOrden;
    @OneToOne
    private SubOpcionLlamada subOpcionLlamada;

    public OpcionLlamada(String nombreOpcionLlamada, int nroOrden, SubOpcionLlamada subOpcionLlamada) {
        this.nombreOpcionLlamada = nombreOpcionLlamada;
        this.nroOrden = nroOrden;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    

    public String getNombreOpcionLlamada() {
        return nombreOpcionLlamada;
    }

    public SubOpcionLlamada getSubOpcionLlamada() {
        return subOpcionLlamada;
    }
    
        /*
    Metodo #18
    Realiza la busqueda de la validaciones
    */
    public List<Validacion> buscarValidaciones(){
        return subOpcionLlamada.buscarValidaciones();
    }

    
    
    
    
}
