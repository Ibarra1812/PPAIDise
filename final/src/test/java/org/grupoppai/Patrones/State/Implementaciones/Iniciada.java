package org.grupoppai.Patrones.State.Implementaciones;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;
import org.grupoppai.Patrones.State.Estado;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
@DiscriminatorValue("INICIADA")
public class Iniciada extends Estado {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void tomarPorOperador(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambiosEstado) {

        // Se obtiene el estado actual y se actualiza su fecha y hora de fin.
        CambioEstado actual = cambiosEstado.get(0);
        actual.setFechaHoraFin(fechaHoraActual);

        // Se crean el nuevo estado y el nuevo cambio de estado
        Estado nuevoEstado = crearProximoEstado();
        CambioEstado nuevoCambio = crearCambioEstado(fechaHoraActual, nuevoEstado);

        // Se setea el estado a la llamada y se le agrega el nuevo cambio
        llamada.setEstadoActual(nuevoEstado);
        llamada.agregarCambio(nuevoCambio);
    }

    @Override
    public void finalizarLlamada(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception {
        System.out.println("Finalizando...");
    }

    @Override
    public void cancelarLlamada() throws Exception {
        System.out.println("El cliente colgó la llamada!");
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

    // Método para crear el próximo estado
    public Estado crearProximoEstado() {
        return new EnCurso();
    }

    // Método para crear un nuevo cambio de estado
    public CambioEstado crearCambioEstado(LocalDateTime fechaHoraActual, Estado estado) {
        return new CambioEstado (fechaHoraActual, estado);
    }
}