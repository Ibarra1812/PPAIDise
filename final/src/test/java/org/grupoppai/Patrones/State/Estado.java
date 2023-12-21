package org.grupoppai.Patrones.State;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// Anotación que indica que es una clase con persistencia.

/*
    Si bien Estado es una clase abstracta (no debería crear objetos, i.e no debería tener registros
    en la BBDD), debido a que estamos utilizando la Simulación de la Herencia, la tabla en la base de
    datos almacena los nombres de los estados concretos.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Anotación correspondiente a la Simulación de Herencia.
@DiscriminatorColumn(name = "tipo_estado") // Columna utilizada para devolver un estado concreto.
public abstract class Estado {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributo por valor de Estado.
    private String nombre;

    // Constructor sin parámetros.
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
}