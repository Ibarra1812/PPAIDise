
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Llamada {
    private String descOperador = "";
    private String detaleAccionRequerida = " ";
    private int duracion = 0;
    private boolean encuestaEnviada = false;
    private String observacionAuditor = "";
    private Cliente cliente;
    private CambioEstado cambioEstado;
    private Estado estado;
    OpcionLlamada opcionLlamada;
    private SubOpcionLlamada subOpcionLlamada;
    

    public Llamada(Cliente cliente, Estado estado, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada, CambioEstado cambioEstado) {
        this.cambioEstado = cambioEstado;
        this.cliente = cliente;
        this.estado = estado;
        this.opcionLlamada = opcionLlamada;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    public OpcionLlamada getOpcionLlamada() {
        return opcionLlamada;
    }

    public SubOpcionLlamada getSubOpcionLlamada() {
        return subOpcionLlamada;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    
    
    

    public String getNombreCompleto() {
        return cliente.getNombreCompleto();
    }


    
    public void tomadaPorOperador(Estado estado){
        crearCambioEstado(estado);
        setEstadoActual(estado);
        
    }

    public void setEstadoActual(Estado estado) {
        this.estado = estado;
        
    }
    
    public void crearCambioEstado(Estado estado){
        
        CambioEstado camEstado = new CambioEstado("2018-02-27T12:26:30.107",estado);
        setCambioEstado(camEstado);
        
    }

    public void setCambioEstado(CambioEstado cambioEstado) {
        this.cambioEstado = cambioEstado;
    }
    

    @Override
    public String toString() {
        return "Llamada{" + "descOperador=" + descOperador + ", detaleAccionRequerida=" + detaleAccionRequerida + ", duracion=" + duracion + ", encuestaEnviada=" + encuestaEnviada + ", observacionAuditor=" + observacionAuditor + ", cliente=" + cliente + ", cambioEstado=" + cambioEstado.getFechayHora() + ", estado=" + estado.getNombre() + ", opcionLlamada=" + opcionLlamada + ", subOpcionLlamada=" + subOpcionLlamada + '}';
    }
    
    
}
