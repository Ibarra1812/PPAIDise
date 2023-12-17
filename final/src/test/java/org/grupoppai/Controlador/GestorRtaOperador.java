package org.grupoppai.Controlador;


import org.grupoppai.Modelos.*;
import org.grupoppai.Vista.PantallaRtaOperador;
import org.grupoppai.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;


public class GestorRtaOperador {
    //Definimos las variables que vamos a usar en el gestor.
    private Estado estado;
    private Cliente cliente;
    private CambioEstado cambioEstado;
    private Llamada llamada;
    private CategoriaLlamada categoriaSeleccionada;
    private OpcionLlamada opcionSeleccionada;
    private SubOpcionLlamada subOpcionSeleccionada;
    private String[] datosPantalla;
    private PantallaRtaOperador pantallaRtaOperador; //PantallaRtaOperador, crea la dependencia entre el gestor y la pantalla.
    private LocalDateTime FechayHoraActual;
    private LocalDateTime FechayHoraInicio;
    private List<Estado> estados;
    private HibernateConfig HibernateUtil;
    private List<Validacion> validaciones;
    private List<String> datosCategoriaOpcionSubOpcion;

    private List<String> datosValidaciones;

    private String nombreCliente;


    //Le asignamos la pantalla al gestor.
    public void setPantalla(PantallaRtaOperador pantallaRtaOperador) {
        this.pantallaRtaOperador = pantallaRtaOperador;
    }

    //INICIA LA SECUENCIA
    public void nuevaRespuestaOperador(Llamada llamada, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        
        //Se reciben los datos necesarios para ejecutar el cu correctamente.
        recibirLlamada(llamada, categoriaLlamada, opcionLlamada, subOpcionLlamada);

        //Hacemos que la llamada sea tomada por el operador.
        llamada.tomadaPorOperador(buscarEstadoEnCurso());

        //obtiene los datos asociados a la llamada.
        obtenerDatosLlamada(llamada, categoriaLlamada, opcionLlamada, subOpcionLlamada);

        // Obtiene los datos de las validaciones
        buscarValidaciones(opcionLlamada, subOpcionLlamada);
        
        //mostramos los datos de la llamada y de validacion en la pantalla.
        this.pantallaRtaOperador.mostrarDatosLlamadaYValidaciones(this.datosValidaciones, this.nombreCliente, this.datosCategoriaOpcionSubOpcion);
    }
    
    //Metodo para Recibir llamada
    public void recibirLlamada(Llamada llamada, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        this.llamada = llamada;
        this.categoriaSeleccionada = categoriaLlamada;
        this.opcionSeleccionada = opcionLlamada;
        this.subOpcionSeleccionada = subOpcionLlamada;

        estados = (List<Estado>) session.createQuery("FROM Estado", Estado.class).getResultList();

        validaciones = (List<Validacion>) session.createQuery("FROM Validacion", Validacion.class).getResultList();

    }

    //Metodo encargado de buscar el estado "En curso".
    public Estado buscarEstadoEnCurso(){
        
        //Ciclo que recorres los estados para determinar cual es el "En curso".
        for (int i=0; i<estados.size();i++){
            //Variable creada para comparar el estado necesitado con los que estan disponibles.
            Estado estadoComparacion = estados.get(i);
            
            //Condicional para comparar si es "En Curso".
            if (estadoComparacion.esEnCurso(estadoComparacion)){
               
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
    public void obtenerDatosLlamada(Llamada llamada, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        this.cliente = llamada.getCliente();
        this.nombreCliente = llamada.getNombreCompleto();
        this.datosCategoriaOpcionSubOpcion = categoriaSeleccionada.getDescripcionCompletaCategoriaYOpcion(opcionLlamada, subOpcionLlamada);
    }
    
    
    //Metodo encargado de obtener las validaciones.
    public void buscarValidaciones(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){

        //Busca las validaciones en las opciones.
        this.datosValidaciones = categoriaSeleccionada.buscarValidaciones(opcionLlamada, subOpcionLlamada);

    }

    //Metodo encargado de obtener el dato a validar
    /* Esto solo se realiza para el caso de que solo se escoga una validacion
    public void tomarDatoValidacion() {
        this.validarInformacionCliente(PantallaRtaOperador.tomarIngresoDatoValidacion());

        //enviamos el dato para validar que la informacion sea correcta.
        //validarInformacionCliente(PantallaRtaOperador.tomarIngresoDatoValidacion());

    }
     */

    public void tomarDatoValidacion (String validacion, String datoAValidar) {
        validarInformacionCliente (validacion, datoAValidar);
    }
    
    //Metodo encargado de validar que la opcion de validacion seleccionada sea la correcta.
    /*
    public void validarInformacionCliente(String datoValidacion){
        
        if(cliente.esInformacionCorrecta(datoValidacion)){
            //Llamamos al objeto pantalla que habilite el ingreso de datos.
            PantallaRtaOperador.permitirIngresoDatoOperador();

        }
    }

     */


    public void validarInformacionCliente (String validacion, String datoAValidar) {
        if (cliente.esInformacionCorrecta (validacion, datoAValidar)) {
            System.out.println("CORRECTA");
            pantallaRtaOperador.permitirIngresoDatoOperador();
        } else {
            System.out.println("INCORRECTA");
        }
    }

    //Metodo encargado de recibir la respuesta del operador.
    public void tomarRtaOperador(String[] datosPantalla){
        this.datosPantalla = datosPantalla;
        //Llamamos al objeto pantalla para que solicite la confirmacion;
       //PantallaRtaOperador.solicitarConfirmacion();
        
    }

    
    //Metodo encargado de confirmar las acciones realializadas.
    public void confirmar(){
        //Llamamos al  objeto pantalla para que informe si se llamo correctamente al CU "Registrar Accion requerida"
        //PantallaRtaOperador.InformarAccionRegistrada();
        //Finalizamos la llamada.
        finalizarLlamada();
        //obtenemos la fecha y hora actual.
        LocalDateTime fechayHora = obtenerFechayHoraActual();
        //Buscamos el estado "Finalizada" de la llamada.
        buscarEstadoFinalizada((ArrayList<Estado>) estados);
        //Setteamos la accion registrada.

    }

    //Metodo encargado de finalizar la llamada.
    public void finalizarLlamada(){
        //Llamamos la llamada para que finalice cargando el nuevo cambio de estado y el estado actual.
        llamada.finalizarLlamada(buscarEstadoFinalizada((ArrayList<Estado>) estados),datosPantalla);
    }
    
    
    
    //Metodo encargado de buscar el estado "Finalizada".
    public Estado buscarEstadoFinalizada(ArrayList<Estado> estados){
        
        //Ciclo que recorres los estados para determinar cual es el "Finalizada".
        for (int i=0; i<estados.size();i++){
            //Condicional para comparar si es "Finalizada".
            Estado estadoComparacion = estados.get(i);
            
             //Condicional para comparar si es "Finalizada".
            if(estadoComparacion.esFinalizado(estadoComparacion)){
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
