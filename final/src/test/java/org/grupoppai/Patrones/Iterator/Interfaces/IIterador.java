package org.grupoppai.Patrones.Iterator.Interfaces;

// Interfaz del iterador.
public interface IIterador<T> {
    void primero();
    void siguiente();
    boolean haTerminado();
    boolean cumpleFiltro();
    T actual();
}