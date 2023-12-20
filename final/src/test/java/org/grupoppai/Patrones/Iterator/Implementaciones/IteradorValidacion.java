package org.grupoppai.Patrones.Iterator.Implementaciones;

import org.grupoppai.Modelos.Validacion;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import java.util.List;

public class IteradorValidacion implements IIterador {

    private final List<Validacion> elements;
    private final List<Object> filtros;
    private Integer indice;

    public IteradorValidacion (List<Validacion> elements, List<Object> filtros) {
        this.elements = elements;
        this.filtros = filtros;
    }

    // Se setea el índice en la primera posición.
    @Override
    public void primero() {
        this.indice = 0;
    }

    // Se incrementa en 1 la posición del índice.
    @Override
    public void siguiente() {
        this.indice = this.indice + 1;
    }

    // Se verifica si la lista ya fue recorrida.
    @Override
    public boolean haTerminado() {
        return this.indice >= elements.size();
    }

    // Para este Iterador en particular no existen filtros.
    @Override
    public boolean cumpleFiltro() {
        return true;
    }

    // Se devuelve el objeto que corresponde a la iteración actual.
    @Override
    public Validacion actual() {
        if (this.cumpleFiltro()) {
            return this.elements.get(this.indice);
        }
        return null;
    }
}
