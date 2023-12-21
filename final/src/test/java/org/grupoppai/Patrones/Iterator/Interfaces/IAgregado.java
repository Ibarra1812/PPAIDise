package org.grupoppai.Patrones.Iterator.Interfaces;

import java.util.List;

// Interfaz que implementan los agregados.
public interface IAgregado<T> {

    // Método para crear el iterador con el tipo que requiera el usuario.
    IIterador crearIterador(List<T> elementos, List<Object> filtros);
}