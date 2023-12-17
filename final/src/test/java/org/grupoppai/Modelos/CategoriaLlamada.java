package org.grupoppai.Modelos;


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
    @OneToMany
    private List<OpcionLlamada> opcionLlamada;
    //private List<Validacion> mensajeValidacion;

    public CategoriaLlamada(String nombreCategoria, int nroOrden, List<OpcionLlamada> opcionLlamada) {
        this.nombreCategoria = nombreCategoria;
        this.nroOrden = nroOrden;
        this.opcionLlamada = opcionLlamada;
    }

    public CategoriaLlamada() {

    }


    public List<String> getDescripcionCompletaCategoriaYOpcion(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada) {
        List<String> listaDatos = new ArrayList<>();

        listaDatos.add(this.nombreCategoria);

        List<String> datosOpcionSubOpcion = opcionLlamada.getDescripcionConSubopcion(subOpcionLlamada);
        listaDatos.add(datosOpcionSubOpcion.get(0));
        listaDatos.add(datosOpcionSubOpcion.get(1));

        return listaDatos;
    }


    /*
    public OpcionLlamada getOpcionLlamada() {
        return opcionLlamada;
    }
     */

    //Metodo encargado de buscar validaciones.

    public List<String> buscarValidaciones(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        //Buscar las validaciones en las subOpciones.
        return opcionLlamada.buscarValidaciones(subOpcionLlamada);
    }
    
    
}
