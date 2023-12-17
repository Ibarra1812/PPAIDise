package org.grupoppai.Modelos;


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
    @ManyToMany
    private List<SubOpcionLlamada> subOpcionLlamada;

    public OpcionLlamada(String nombreOpcionLlamada, int nroOrden, List<SubOpcionLlamada> subOpcionLlamada) {
        this.nombreOpcionLlamada = nombreOpcionLlamada;
        this.nroOrden = nroOrden;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    public OpcionLlamada() {

    }

    public List<String> getDescripcionConSubopcion(SubOpcionLlamada subOpcionLlamada){
        List<String> listaDatos = new ArrayList<>();

        listaDatos.add(this.nombreOpcionLlamada);
        listaDatos.add(subOpcionLlamada.getNombre());

        return listaDatos;
    }

    /*
    public String getNombreOpcionLlamada() {
        return nombreOpcionLlamada;
    }

    public SubOpcionLlamada getSubOpcionLlamada() {
        return subOpcionLlamada;
    }

     */
    
        /*
    Metodo #18
    Realiza la busqueda de la validaciones
    */
    public List<String> buscarValidaciones(SubOpcionLlamada subOpcionLlamada){
        return subOpcionLlamada.buscarValidaciones();
    }

    
    
    
    
}
