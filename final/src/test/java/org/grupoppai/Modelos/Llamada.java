package org.grupoppai.Modelos;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Llamada {
    @Override
    public String toString() {
        return "Llamada{" +
                "id=" + id +
                ", descOperador='" + descOperador + '\'' +
                ", detalleAccionRequerida='" + detalleAccionRequerida + '\'' +
                ", duracion=" + duracion +
                ", encuestaEnviada=" + encuestaEnviada +
                ", observacionAuditor='" + observacionAuditor + '\'' +
                ", cliente=" + cliente +
                ", cambioEstado=" + cambioEstado +
                ", estado=" + estado +
                ", accion='" + accion + '\'' +
                ", opcionLlamada=" + opcionLlamada +
                ", subOpcionLlamada=" + subOpcionLlamada +
                '}';
    }

    public Llamada() {
    }



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

    public void tomadaPorOperador(Estado estado){
        
        //Crea el cambio de estado con su fecha, hora y estado correspondiente.
        crearCambioEstado(estado);
        
        //settea el estado actual de la 
        setEstadoActual(estado);
        
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

    
    public void crearCambioEstado(Estado estado){
        
        CambioEstado camEstado = new CambioEstado(LocalDateTime.now(),estado);
        setCambioEstado(camEstado);
        
    }

    public void setCambioEstado(CambioEstado cambioEstado) {
        this.cambioEstado.add(cambioEstado);
    }
    

    //Arraylist necesario para el realizar la comparacion de string y hacer los esFinalizados, y esEnCurso
    public List<CambioEstado> getCambioEstado() {
        return cambioEstado;
    }
    
    //Metodo encargado de finalizar la llamada cargando el estado "Finalizado".
    public void finalizarLlamada(Estado estado,String[] datosPantalla){
        //Calculamos la duracion de la llamada.
        calcularDuracion();
        //Creamos el nuevo cambio de estado.
        crearCambioEstado(estado);
        //Setteamos en nuevo cambio estado.
        setEstadoActual(estado);

        //Setteamos la accion y la respuesta del operador.
        setAccion(datosPantalla[1]);
        setDetalleAccionRequerida(datosPantalla[0]);
        
        System.out.println(getAccion());
        System.out.println(getDetalleAccionRequerida());
    }
    
    //Metodo encargado de calcular la duracion de la llamada 
    public void calcularDuracion(){
        int tiempo_1 = 0;
        int tiempo_2 = 0;
        for(int i=0;i<cambioEstado.size()-1;i++){
            if(cambioEstado.get(i).getEstado().esFinalizado(cambioEstado.get(i).getEstado())){
                tiempo_1 = cambioEstado.get(i).getFechayHoraInicio().getSecond();
                
            }
            if(cambioEstado.get(i).getEstado().esEnCurso(cambioEstado.get(i).getEstado())){
                tiempo_2 = cambioEstado.get(i).getFechayHoraInicio().getSecond();
                    
            }
            
        }
        int tiempo_total = tiempo_2 - tiempo_1;
    
    }
    
    //FLUJO ALTERNATIVO.
    //En caso que el cliente corte la llamada, esta pasa a estado cancelada, 
    //creando el cambio estado y setteando el estado correspondiente.
    public void cancelarLlamada(Estado estado){
        crearCambioEstado(estado);
        setEstadoActual(estado);
        
    }
    
    //Metodo encargado de settear la duracion.
    public void setDuracion(int duracion) {
        this.duracion = duracion;
        
    }  

    public int getDuracion() {
        return duracion;
    }
    
}
