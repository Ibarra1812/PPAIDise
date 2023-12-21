package org.grupoppai.Modelos;


import org.grupoppai.Patrones.Iterator.Implementaciones.IteradorValidacion;
import org.grupoppai.Patrones.Iterator.Interfaces.IAgregado;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
public class SubOpcionLlamada implements IAgregado { // Se implementa la interfaz IAgregado para implementar el Iterator.

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos por valor de SubOpcionLlamada.
    private String nombre;
    private int nroOrden;

    // Atributo por referencia de SubOpcionLlamada.
    @ManyToMany
    private List<Validacion> validacion;

    // Constructor sin parámetros.
    public SubOpcionLlamada() {
    }

    // Método para obtener la descripción de la subopción.
    public String getNombre() {
        return this.nombre;
    }

    
    // Método encargado de obtener los mensajes de las validaciones.
    public List<String> buscarValidaciones() {
        
        // Se crea el arreglo de los mensajes de las validaciones-
        List<String> datosValidaciones = new ArrayList<>();

        // Se crea el iterador. El filtro es nulo porque el iterador no filtra las validaciones.
        IteradorValidacion iteradorValidacion = new IteradorValidacion(validacion, null);

        // Se setea la posición del iterador.
        iteradorValidacion.primero();

        while (!iteradorValidacion.haTerminado()) {
            // Se obtiene el elemento actual.
            Validacion validacion = iteradorValidacion.actual();

            // Se obtiene el mensaje de la validación.
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