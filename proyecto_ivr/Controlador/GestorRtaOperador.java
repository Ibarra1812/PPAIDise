package Controlador;


import Vista.PantallaRtaOperador;
import Modelos.Cliente;
import Modelos.Validacion;
import Modelos.CategoriaLlamada;
import Modelos.Llamada;
import Modelos.CambioEstado;
import Modelos.Estado;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;


public class GestorRtaOperador {
    //Definimos las variables que vamos a usar en el gestor.
    private Estado estado;
    private Cliente cliente;
    private CambioEstado cambioEstado;
    private Llamada llamada;
    private CategoriaLlamada categoriaLlamada;
    private PantallaRtaOperador PantallaRtaOperador; //PantallaRtaOperador, crea la dependencia entre el gestor y la pantalla.
    private LocalDateTime FechayHoraActual;
    private LocalDateTime FechayHoraInicio;
    private ArrayList<Estado> estados;

    //Le asignamos la pantalla al gestor.
    public void setPantalla(PantallaRtaOperador PantallaRtaOperador) {
        this.PantallaRtaOperador = PantallaRtaOperador;
        PantallaRtaOperador.habilitarVentana();
    }

    //INICIA LA SECUENCIA
    public void nuevaRespuestaOperador(Llamada llamada, CategoriaLlamada categoriaLlamada, ArrayList<Estado> estados){
        
        //Se reciben los datos necesarios para ejecutar el cu correctamente.
        recibirLlamada(llamada,categoriaLlamada, estados);
        
        //obtiene los datos asociados a la llamada.
        obtenerDatosLlamada();
        
        //Hacemos que la llamada sea tomada por el operador.
        llamada.tomadaPorOperador(buscarEstadoEnCurso());
        
        //buscamos las validaciones disponibles.
        ArrayList<Validacion> cad = buscarValidaciones();
        
        //mostamos los datos de la llamada y de validacion en la pantalla.
        PantallaRtaOperador.mostrarDatosLlamadayValidaciones(cad);
        
        
    }
    
    //Metodo para Recibir llamada
    public void recibirLlamada(Llamada llamada, CategoriaLlamada categoriaLlamada,ArrayList<Estado> estados){
        this.llamada = llamada;
        this.categoriaLlamada = categoriaLlamada;
        this.estados = estados;
    }

    //Metodo encargado de buscar el estado "En curso".
    public Estado buscarEstadoEnCurso(){
        
        //Ciclo que recorres los estados para determinar cual es el "En curso".
        for (int i=0; i<estados.size();i++){
            //Variable creada para comparar el estado necesitado con los que estan disponibles.
            Estado estadoComparacion = estados.get(i);
            
            //Condicional para comparar si es "En Curso".
            if(estadoComparacion.esEnCurso(estadoComparacion) == true){
               
                return estadoComparacion;
                
            } 
        }
        return null;
        
        
    }

    //Metodo encargado de obtener fecha y hora actual
    public LocalDateTime obtenerFechayHoraActual(){
        LocalDateTime FechaHoraActual = LocalDateTime.now();
        return FechaHoraActual;
    }
    
    //Metodo encargado de obtener los datos de la llamada.
    public String[] obtenerDatosLlamada(){
        //Vector donde se contiene todos los datos relacionados a la llamada.       
        String datos[];
        datos = new String[4];
        
        //Obtiene el nombre completo del cliente.
        datos[0] = llamada.getNombreCompleto();
        
        //Obtiene el nombre de la categoria.
        datos[1] = categoriaLlamada.getNombreCategoria();
        
        //Obtiene el nombre de la opcion.
        datos[2] = llamada.getOpcionLlamada().getNombreOpcionLlamada();
        
        //Obtiene el nombre de la subOpcion.
        datos[3] = llamada.getSubOpcionLlamada().getNombre();
        
        
        
        return datos;
        
    }
    
    
    //Metodo encargado de obtener las validaciones.
    public ArrayList<Validacion> buscarValidaciones(){
        
        //Busca las validaciones en las opciones.
        return categoriaLlamada.buscarValidaciones();
       
    }

    //Metodo encargado de obtener el dato a validar
    public void tomarDatoValidacion(){
        
        //Cargamos el dato obtenido del combo en una variable.
        String datoValidacion = PantallaRtaOperador.tomarIngresoDatoValidacion();
        //enviamos el dato para validar que la informacion sea correcta.
        validarInformacionCliente(datoValidacion);
        
    }
    
    //Metodo encargado de validar que la opcion de validacion seleccionada sea la correcta.
    public void validarInformacionCliente(String datoValidacion){
        
        if(llamada.getCliente().esInformacionCorrecta(datoValidacion) == true){
            PantallaRtaOperador.permitirIngresoDatoOperador();

        }
        
    }

    //Metodo encargado de recibir la respuesta del operador.
    public void tomarRtaOperador(){
        llamada.setDescOperador(PantallaRtaOperador.tomarRespuestaOperador());
    }

    //Metodo encargado de tomar la confirmacion.
    public void tomarConfirmacion(){
        PantallaRtaOperador.tomarConfirmacion();
    }
    
    //Metodo encargado de confirmar las acciones realializadas.
    public void confirmar(){
        //Creamos un objeto pantalla que informa si se llamo correctamente al CU "Registrar Accion requerida"
        PantallaRtaOperador.InformarAccionRegistrada();
        finalizarLlamada();
        LocalDateTime fechayHora = obtenerFechayHoraActual();
        buscarEstadoFinalizada(estados);
        
    
    }

    //Metodo encargado de finalizar la llamada.
    public void finalizarLlamada(){
        
        llamada.finalizarLlamada(buscarEstadoFinalizada(estados));
        
    }
    
    
    
    //Metodo encargado de buscar el estado "Finalizada".
    public Estado buscarEstadoFinalizada(ArrayList<Estado> estados){
        
        //Ciclo que recorres los estados para determinar cual es el "En curso".
        for (int i=0; i<estados.size();i++){
            //Condicional para comparar si es "En Curso".
            Estado estadoComparacion = estados.get(i);
            
             //Condicional para comparar si es "En Curso".
            if(estadoComparacion.esFinalizado(estadoComparacion) == true){
                return estadoComparacion;

            } 
        }
        return null;
    }
    
    
    //FLUJO ALTERNATIVO
    //metodo que se encarga de finalizar la llamada en caso que se el cliente cuelgue.
    //crea el cambio estado y cierra el software.
    public void cancelarLlamada(){
        llamada.cancelarLlamada(estado);
        
        System.exit(0);
    
    }
    
}
