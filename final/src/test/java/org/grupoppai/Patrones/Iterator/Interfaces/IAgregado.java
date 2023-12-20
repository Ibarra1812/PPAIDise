package org.grupoppai.Patrones.Iterator.Interfaces;

import java.util.List;

public interface IAgregado<T> {

    IIterador crearIterador(List<T> elementos, List<Object> filtros);
}