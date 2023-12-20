package org.grupoppai.Modelos;

import org.grupoppai.Patrones.State.Estado;
import org.hibernate.Session;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Llamada {

    /*
     * Construct
     * Se establecen los atributos de la clase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descOperador = "";
    private String detalleAccionRequerida = " ";

    private int duracion;
    private boolean encuestaEnviada = false;
    private String observacionAuditor = "";
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<CambioEstado> cambioEstado;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    private String accion;
    @ManyToOne
    private OpcionLlamada opcionLlamada;
    @ManyToOne
    private SubOpcionLlamada subOpcionLlamada;

    public Llamada(Long id, String descOperador, String detalleAccionRequerida, int duracion, boolean encuestaEnviada, String observacionAuditor, Cliente cliente, List<CambioEstado> cambioEstado, Estado estado, String accion, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada) {
        this.id = id;
        this.descOperador = descOperador;
        this.detalleAccionRequerida = detalleAccionRequerida;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
        this.observacionAuditor = observacionAuditor;
        this.cliente = cliente;
        this.cambioEstado = cambioEstado;
        this.estado = estado;
        this.accion = accion;
        this.opcionLlamada = opcionLlamada;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    public Llamada() {
    }

    public void tomadaPorOperador (LocalDateTime fechaHoraActual) {
        // Bloque try generado por el lenguaje.
        try {
            this.estado.tomarPorOperador(this, fechaHoraActual, this.cambioEstado);

        // Bloque catch generado por el lenguaje.
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
   
    public OpcionLlamada getOpcionLlamada() {
        return opcionLlamada;
    }

    public SubOpcionLlamada getSubOpcionLlamada() {
        return subOpcionLlamada;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    //Metodo encargado de setter la accion seleccionada.
    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public String getDetalleAccionRequerida() {
        return detalleAccionRequerida;
    }

    public void setDetalleAccionRequerida(String detalleAccionRequerida) {
        this.detalleAccionRequerida = detalleAccionRequerida;
    }
    

    public String getNombreCompleto() {
        return cliente.getNombreCompleto();
    }

    public void setEstadoActual(Estado estado) {
        this.estado = estado;
    }

    public void setDescOperador(String descOperador) {
        this.descOperador = descOperador;
    }

    public void finalizarLlamada (LocalDateTime fechaHoraActual) {
        // Bloque try generado por el lenguaje.
        try {
            this.estado.finalizarLlamada(this, fechaHoraActual, cambioEstado);

            // Bloque catch generado por el lenguaje.
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    //Metodo encargado de settear la duracion.
    public void setDuracion (int duracion) {
        this.duracion = duracion;
        
    }  

    public int getDuracion() {
        return duracion;
    }

    // Método para agregar el cambio de estado
    public void agregarCambio(CambioEstado nuevoCambio) {
        this.cambioEstado.add(nuevoCambio);
    }

    public void imprimirCambios() {
        for (CambioEstado cambio: this.cambioEstado) {
            System.out.println(cambio.getFechaHoraInicio());
        }
    }

    public String getDescOperador() {
        return this.descOperador;
    }

    public Estado getEstadoActual() {
        return this.estado;
    }

    public List<CambioEstado> getCambioEstado() {
        return this.cambioEstado;
    }
}