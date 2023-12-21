package org.grupoppai.Modelos;

import org.grupoppai.Patrones.State.Estado;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
public class Llamada {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos por valor de Llamada.
    private String descOperador;
    private String detalleAccionRequerida;
    private int duracion;
    private boolean encuestaEnviada;
    private String observacionAuditor;
    private String accion;

    // Atributos por referencia de Llamada.
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<CambioEstado> cambioEstado;
    @ManyToOne
    @JoinColumn(name = "estado_id") // Apunta a un estado concreto. Implementamos el State.
    private Estado estado;
    @ManyToOne
    private OpcionLlamada opcionLlamada;
    @ManyToOne
    private SubOpcionLlamada subOpcionLlamada;

    // Constructor sin parámetros.
    public Llamada() {
    }

    // Método para tomar la llamada por el operador. Genera un cambio de estado.
    public void tomadaPorOperador (LocalDateTime fechaHoraActual) {
        // Bloque try generado por el lenguaje.
        try {
            // Se delega la responsabilidad al estado concreto (Iniciada).
            this.estado.tomarPorOperador(this, fechaHoraActual, this.cambioEstado);

        // Bloque catch generado por el lenguaje.
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
   
    // Método encargado de obtener al cliente de la llamada.
    public Cliente getCliente() {
        return this.cliente;
    }

    // Método encargado de obtener el nombre completo del cliente.
    public String getNombreCompleto() {
        return cliente.getNombreCompleto();
    }

    // Método para setear el estado actual de la llamada. Es un estado concreto.
    public void setEstadoActual(Estado estado) {
        this.estado = estado;
    }

    // Método para setear la descripción del operador ingresada por el usuario.
    public void setDescOperador(String descOperador) {
        this.descOperador = descOperador;
    }

    // Método para finalizar la llamada. Genera un cambio de estado.
    public void finalizarLlamada (LocalDateTime fechaHoraActual) {
        // Bloque try generado por el lenguaje.
        try {
            // Se delega la responsabilidad al estado concreto (EnCurso).
            this.estado.finalizarLlamada(this, fechaHoraActual, cambioEstado);

            // Bloque catch generado por el lenguaje.
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    // Metodo encargado de setear la duración.
    public void setDuracion (int duracion) {
        this.duracion = duracion;
        
    }

    // Método para agregar el nuevo cambio de estado.
    public void agregarCambio(CambioEstado nuevoCambio) {
        this.cambioEstado.add(nuevoCambio);
    }

    // Método para obtener la lista de cambios de estado y hacerlos persistentes.
    public List<CambioEstado> getCambioEstado() {
        return this.cambioEstado;
    }
}