package org.grupoppai.Modelos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
public class OpcionLlamada {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos por valor de OpcionLlamada.
    private String nombreOpcionLlamada;
    private int nroOrden;

    // Atributo por referencia de OpcionLlamada.
    @ManyToMany
    private List<SubOpcionLlamada> subOpcionLlamada;

    // Constructor sin parámetros.
    public OpcionLlamada() {
    }

    // Método para obtener la descripción de la opción y de la subopción seleccionada.
    public List<String> getDescripcionConSubopcion(SubOpcionLlamada subOpcionLlamada){
        // Se crea un nuevo arreglo para almacenar la descripción de la opción y de la subopción.
        List<String> listaDatos = new ArrayList<>();

        // Se agrega la descripción de la opción.
        listaDatos.add(this.nombreOpcionLlamada);

        // Se obtiene la descripción de la subopción.
        listaDatos.add( subOpcionLlamada.getNombre() );

        return listaDatos;
    }

    // Método utilizado para obtener los mensajes de las validaciones.
    public List<String> buscarValidaciones(SubOpcionLlamada subOpcionLlamada){
        return subOpcionLlamada.buscarValidaciones();
    }
}