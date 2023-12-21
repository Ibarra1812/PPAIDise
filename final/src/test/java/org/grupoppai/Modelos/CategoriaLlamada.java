package org.grupoppai.Modelos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
public class CategoriaLlamada {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atbitutos por valor de CategoriaLlamada.
    private String nombreCategoria;
    private int nroOrden;

    // Atributo por referencia de CategoriaLlamada.
    @OneToMany
    private List<OpcionLlamada> opcionLlamada;

    // Constructor de CategoriaLlamada.
    public CategoriaLlamada() {
    }

    // Método para obtener la descripción completa de la categoría, la opción y la subopción.
    public List<String> getDescripcionCompletaCategoriaYOpcion(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada) {
        // Se arma un arreglo con la lista de datos.
        List<String> listaDatos = new ArrayList<>();

        // Se añade la categoría al arreglo.
        listaDatos.add(this.nombreCategoria);

        // Se delega la responsabilidad a la opción seleccionada de obtener el mensaje de la opción y de la subopción seleccionada.
        List<String> datosOpcionSubOpcion = opcionLlamada.getDescripcionConSubopcion(subOpcionLlamada);

        // Se añaden los mensajes de la opción y la subopción seleccionadas.
        listaDatos.add(datosOpcionSubOpcion.get(0));
        listaDatos.add(datosOpcionSubOpcion.get(1));

        return listaDatos;
    }

    // Método encargado de obtener los mensajes de las validaciones.
    public List<String> buscarValidaciones(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        // Se delega la responsabilidad a la opción seleccionada.
        return opcionLlamada.buscarValidaciones(subOpcionLlamada);
    }
}