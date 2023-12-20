package org.grupoppai.Modelos;

import org.grupoppai.Patrones.State.Estado;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public CambioEstado() {
    }

    public boolean esActual() {
        return this.fechaHoraFin == null;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public Estado getEstado() {
        return this.estado;
    }

}
