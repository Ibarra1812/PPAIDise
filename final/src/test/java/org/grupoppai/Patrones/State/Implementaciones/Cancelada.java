package org.grupoppai.Patrones.State.Implementaciones;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;
import org.grupoppai.Patrones.State.Estado;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
@DiscriminatorValue("CANCELADA")
public class Cancelada extends Estado {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public void tomarPorOperador(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    @Override
    public void finalizarLlamada(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    @Override
    public void cancelarLlamada() throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    @Override
    public void descartarLlamada() throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    @Override
    public void registrarPendiente() throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    @Override
    public void registrarEscucha() throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }
}
