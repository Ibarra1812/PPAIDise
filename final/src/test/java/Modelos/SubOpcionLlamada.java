package Modelos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubOpcionLlamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int nroOrden;
    @ManyToMany
    private List<Validacion> validacion;

    public SubOpcionLlamada(String nombre, int nroOrden, List<Validacion> validacion) {
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.validacion = validacion;
    }

    

    public String getNombre() {
        return nombre;
    }

    
    //Metodo encargado de buscar validaciones
    public List<Validacion> buscarValidaciones() {
        
        //Devuelve la validacion requerida por las opciones seleccionadas por el cliente.
        return validacion;
    }
    
    
    

    
    
    
}
