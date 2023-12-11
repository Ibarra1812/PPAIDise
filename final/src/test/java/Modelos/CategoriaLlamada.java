package Modelos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriaLlamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCategoria;
    private int nroOrden;
    @OneToOne
    private OpcionLlamada opcionLlamada;

    public CategoriaLlamada(String nombreCategoria, int nroOrden, OpcionLlamada opcionLlamada) {
        this.nombreCategoria = nombreCategoria;
        this.nroOrden = nroOrden;
        this.opcionLlamada = opcionLlamada;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public OpcionLlamada getOpcionLlamada() {
        return opcionLlamada;
    }

    //Metodo encargado de buscar validaciones.
    public List<Validacion> buscarValidaciones(){
        
        //Buscar las validaciones en las subOpciones.
        return opcionLlamada.buscarValidaciones();
        
    }
    
    
}
