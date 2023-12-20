package org.grupoppai.Patrones.State;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_estado")
public abstract class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Estado() {
    }

    /*
        Métodos presentes en la máquina de estados. Los métodos son abstractos para que cada estado
        concreto implemente su comportamiento.

        Los métodos arrojan excepciones para que no sea posible llamar a un comportamiento
        dependiente del estado al estado incorrecto. Por ejemplo, al estado 'Iniciada' no se le debe
        llamar al método registrarEscucha(), por lo que, en la clase Iniciada, el método arrojará
        una excepción.
     */

    public abstract void tomarPorOperador(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception;
    public abstract void finalizarLlamada(Llamada llamada, LocalDateTime fechaHoraActual, List<CambioEstado> cambioEstado) throws Exception;
    public abstract void cancelarLlamada() throws Exception;
    public abstract void descartarLlamada() throws Exception;
    public abstract void registrarPendiente() throws Exception;
    public abstract void registrarEscucha() throws Exception;

    public String getNombre() {
        return this.nombre;
    }
}