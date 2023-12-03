package Modelos;


import java.time.Duration;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Llamada {
    /*
     * Construct
     * Se establecen los atributos de la clase
     */
    private String descOperador = "";
    private String detaleAccionRequerida = " ";


    private long duracion;
    private boolean encuestaEnviada = false;
    private String observacionAuditor = "";
    private Cliente cliente;
    private ArrayList<CambioEstado> cambioEstado = new ArrayList<>();
    private Estado estado;
    private OpcionLlamada opcionLlamada;
    private SubOpcionLlamada subOpcionLlamada;
    

    public Llamada(Cliente cliente, Estado estado, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada, ArrayList<CambioEstado> cambioEstado) {
        this.cambioEstado = new ArrayList<>();
        this.cliente = cliente;
        this.estado = estado;
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
        return cliente;
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
    public ArrayList<CambioEstado> getCambioEstado() {
        return cambioEstado;
    }
    
    //Metodo encargado de finalizar la llamada cargando el estado "Finalizado".
    public void finalizarLlamada(Estado estado){
        //Creamos el nuevo cambio de estado.
        crearCambioEstado(estado);
        //Setteamos en nuevo cambio estado.
        setEstadoActual(estado);
        //Calculamos la duracion de la llamada.
        calcularDuracion();
        
    }
    
    //Metodo encargado de calcular la duracion de la llamada
    public void calcularDuracion(){
      //creamos variables para el inicio y fin de la llamada.
      LocalTime horaFin = LocalTime.of(22,30);
      LocalTime horaInicio = LocalTime.of(20,30);
      
      //Obtenemos la diferencia de horarios.
      Duration duracion = Duration.between(horaInicio, horaFin);
      
      //Pasmos la diferencia de horas a minutos.
      long duracionMin = duracion.toMinutes();
      //Setteamos la duracion de la llamada en minutos.
      setDuracion(duracionMin);
    }
    
    //FLUJO ALTERNATIVO.
    //En caso que el cliente corte la llamada, esta pasa a estado cancelada, 
    //creando el cambio estado y setteando el estado correspondiente.
    public void cancelarLlamada(Estado estado){
        crearCambioEstado(estado);
        setEstadoActual(estado);
        
    }
    
    //Metodo encargado de settear la duracion.
    public void setDuracion(long duracion) {
        this.duracion = duracion;
        
    }  

    public long getDuracion() {
        return duracion;
    }
    
}
