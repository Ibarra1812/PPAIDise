package org.grupoppai.Modelos;

import org.grupoppai.Patrones.State.Estado;

import javax.persistence.*;
import java.time.LocalDateTime;

// Anotación que indica que es una clase con persistencia.
@Entity
public class CambioEstado {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos por valor de CambioEstado.
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    // Atributo por referencia de CambioEstado. Apunta a un estado concreto ya que estamos implementando el State.
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    // Constructor de CambioEstado con parámetros.
    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    // Constructor de CambioEstado sin parámetros.
    public CambioEstado() {
    }

    // Método para setear la fecha y hora de fin del CambioEstado.
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    // Método para determinar si es el último cambio de estado.
    public boolean esActual() {
        return this.fechaHoraFin == null;
    }

    // Método para obtener la fecha y la hora de inicio del cambio de estado.
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    // Método para obtener el estado concreto al que apunta el cambio de estado.
    public Estado getEstado() {
        return this.estado;
    }
}