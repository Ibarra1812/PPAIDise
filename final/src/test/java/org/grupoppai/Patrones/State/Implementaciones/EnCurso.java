package org.grupoppai.Patrones.State.Implementaciones;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;
import org.grupoppai.Patrones.State.Estado;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("ENCURSO")
public class EnCurso extends Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public void tomarPorOperador(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception {
        throw new Exception("Este comportamiento no corresponde a este estado.");
    }

    public void finalizarLlamada(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambiosEstado) {
        // Se calcula la duración de la llamada
        int duracion = calcularDuracion(cambiosEstado, fechaHoraActual);

        // Se obtiene el cambio de estado actual y se actualiza su fecha y hora de fin
        CambioEstado actual = buscarCambioEstado(cambiosEstado);
        actual.setFechaHoraFin(fechaHoraActual);

        // Se crean el nuevo estado y el nuevo cambio de estado
        Estado nuevoEstado = crearProximoEstado();
        CambioEstado nuevoCambio = crearCambioEstado(fechaHoraActual, nuevoEstado);

        // Se setean la duración y el estado a la llamada y se le agrega el nuevo cambio
        llamada.setDuracion(duracion);
        llamada.setEstadoActual(nuevoEstado);
        llamada.agregarCambio(nuevoCambio);
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

    // Método para calcular la duración de la llamada
    private int calcularDuracion(List<CambioEstado> cambiosEstado, LocalDateTime fechaHoraActual) {
        return cambiosEstado.get(0).getFechaHoraInicio().getMinute() - fechaHoraActual.getMinute();
    }

    // Método para buscar el cambio de estado actual
    public CambioEstado buscarCambioEstado(List<CambioEstado> cambiosEstado) {
        for (CambioEstado cambio: cambiosEstado) {
            if (cambio.esActual()) {
                return cambio;
            }
        }
        return null;
    }

    // Método para crear el próximo estado
    public Estado crearProximoEstado() {
        return new Finalizada();
    }

    // Método para crear un nuevo cambio de estado
    public CambioEstado crearCambioEstado(LocalDateTime fechaHoraActual, Estado estado) {
        return new CambioEstado (fechaHoraActual, estado);
    }
}