package org.grupoppai.Modelos;


import org.grupoppai.Patrones.Iterator.Implementaciones.IteradorValidacion;
import org.grupoppai.Patrones.Iterator.Interfaces.IAgregado;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubOpcionLlamada implements IAgregado {
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

    public SubOpcionLlamada() {

    }


    public String getNombre() {
        return this.nombre;
    }

    
    // Método encargado de buscar validaciones
    public List<String> buscarValidaciones() {
        
        // Devuelve la validacion requerida por las opciones seleccionadas por el cliente.
        List<String> datosValidaciones = new ArrayList<>();

        // Se crea el iterador. El filtro es nulo porque el iterador no filtra las validaciones.
        IteradorValidacion iteradorValidacion = new IteradorValidacion(validacion, null);

        // Se setea la posición del iterador.
        iteradorValidacion.primero();

        while (!iteradorValidacion.haTerminado()) {
            // Se obtiene el elemento actual y se obtiene el mensaje de la validación.
            Validacion validacion = iteradorValidacion.actual();
            datosValidaciones.add(validacion.getMensajeValidacion());

            // Se incrementa la posición del iterador.
            iteradorValidacion.siguiente();
        }

        return datosValidaciones;
    }

    // Método de la interfaz IAgregado para crear el iterador.
    @Override
    public IIterador crearIterador(List elementos, List filtros) {
        return new IteradorValidacion(elementos, filtros);
    }
}
