package org.grupoppai.Controlador;


import org.grupoppai.Modelos.*;
import org.grupoppai.Patrones.State.Estado;
import org.grupoppai.Persistencia.Persistencia;
import org.grupoppai.Vista.PantallaRtaOperador;
import org.grupoppai.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    private PantallaRtaOperador pantallaRtaOperador; //PantallaRtaOperador, crea la dependencia entre el gestor y la pantalla.
    private HibernateConfig HibernateUtil;
    private List<Validacion> validaciones;
    private List<String> datosCategoriaOpcionSubOpcion;

    private List<String> datosValidaciones;

    private String nombreCliente;
    private String respuestaOperador;
    private Session session;


    //Le asignamos la pantalla al gestor.
    public void setPantalla(PantallaRtaOperador pantallaRtaOperador) {
        this.pantallaRtaOperador = pantallaRtaOperador;
    }

    //INICIA LA SECUENCIA
    public void nuevaRespuestaOperador(){
        
        //Se reciben los datos necesarios para ejecutar el cu correctamente.
        recibirLlamada();

        //Hacemos que la llamada sea tomada por el operador.
        this.llamada.tomadaPorOperador(obtenerFechayHoraActual());

        //obtiene los datos asociados a la llamada.
        obtenerDatosLlamada(this.llamada, this.categoriaSeleccionada, this.opcionSeleccionada, this.subOpcionSeleccionada);

        // Obtiene los datos de las validaciones
        buscarValidaciones(this.opcionSeleccionada, this.subOpcionSeleccionada);
        
        //mostramos los datos de la llamada y de validacion en la pantalla.
        this.pantallaRtaOperador.mostrarDatosLlamadaYValidaciones(this.datosValidaciones, this.nombreCliente, this.datosCategoriaOpcionSubOpcion);
    }
    
    // Método para recibir los datos de la llamada
    public void recibirLlamada () {
        this.obtenerDatosBBDD();
    }

    // Método para obtener la fecha y hora actual
    public LocalDateTime obtenerFechayHoraActual(){
        return LocalDateTime.now();
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

    public void tomarDatoValidacion (int validacion, String datoAValidar) {
        validarInformacionCliente (this.validaciones.get(validacion), datoAValidar);
    }

    public void validarInformacionCliente (Validacion validacion, String datoAValidar) {
        if (cliente.esInformacionCorrecta (validacion, datoAValidar)) {
            this.pantallaRtaOperador.permitirIngresoDatoOperador();
        } else {
            this.pantallaRtaOperador.mostrarDatoValidacionIncorrecto();
        }
    }

    // Método encargado de recibir la respuesta del operador.
    public void tomarRtaOperador (String respuestaOperador) {
        this.respuestaOperador = respuestaOperador;
        pantallaRtaOperador.solicitarConfirmacion();
    }

    
    // Método encargado de confirmar las acciones realizadas.
    public void confirmar() {
        this.pantallaRtaOperador.informarAccionRegistrada();
        this.llamada.setDescOperador(this.respuestaOperador);
        this.finalizarLlamada();
        this.finCU();
    }

    // Método encargado de finalizar la llamada
    public void finalizarLlamada(){
        this.llamada.finalizarLlamada(obtenerFechayHoraActual());
    }

    public void finCU() {
        this.guardarDatosEnBBDD();

        System.out.println("Fin CU.");

        /* Imprimiendo los datos de la llamada (TEST)

        System.out.println("Respuesta operador: " + this.llamada.getDescOperador());
        System.out.println("Duracion: " + this.llamada.getDuracion());
        System.out.println("Cambios de estado: ");
        this.llamada.imprimirCambios();

         */

    }

    // Método para obtener los datos de la BBDD
    private void obtenerDatosBBDD() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        this.session = sessionFactory.openSession();

        this.llamada = this.session.createQuery("FROM Llamada", Llamada.class).getResultList().get(0);
        this.categoriaSeleccionada = this.session.createQuery("FROM CategoriaLlamada", CategoriaLlamada.class).getResultList().get(0);
        this.opcionSeleccionada = this.session.createQuery("FROM OpcionLlamada", OpcionLlamada.class).getResultList().get(0);
        this.subOpcionSeleccionada = this.session.createQuery("FROM SubOpcionLlamada", SubOpcionLlamada.class).getResultList().get(0);

        this.validaciones = session.createQuery("FROM Validacion", Validacion.class).getResultList();
    }

    // Método para invocar la clase de fabricación pura que guarda los datos en la BBDD
    private void guardarDatosEnBBDD() {
        Persistencia.persistirObjetos(this.session, this.llamada);
    }
}