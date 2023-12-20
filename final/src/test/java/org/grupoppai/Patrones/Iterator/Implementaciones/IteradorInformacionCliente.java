package org.grupoppai.Patrones.Iterator.Implementaciones;

import org.grupoppai.Modelos.InformacionCliente;
import org.grupoppai.Modelos.Validacion;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import java.util.List;

public class IteradorInformacionCliente implements IIterador {

    List<InformacionCliente> elements;
    List<Object> filtros;
    Integer indice;

    public IteradorInformacionCliente (List<InformacionCliente> elements, List<Object> filtros) {
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

    // Se verifica que el objeto tenga la validación correspondiente.
    @Override
    public boolean cumpleFiltro() {
        return this.elements.get(this.indice).esValidacion( (Validacion) this.filtros.get(0) );
    }

    // Se devuelve el objeto que corresponde a la iteración actual.
    @Override
    public InformacionCliente actual() {
        if (cumpleFiltro()) {
            return this.elements.get(this.indice);
        }
        return null;
    }
}