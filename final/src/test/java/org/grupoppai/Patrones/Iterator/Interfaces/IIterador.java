package org.grupoppai.Patrones.Iterator.Interfaces;

public interface IIterador<T> {
    void primero();
    void siguiente();
    boolean haTerminado();
    boolean cumpleFiltro();
    T actual();
}