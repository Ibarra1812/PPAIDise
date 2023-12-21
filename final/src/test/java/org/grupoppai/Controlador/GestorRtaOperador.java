package org.grupoppai.Controlador;


import org.grupoppai.Modelos.*;
import org.grupoppai.Patrones.State.Estado;
import org.grupoppai.Persistencia.Persistencia;
import org.grupoppai.Vista.PantallaRtaOperador;
import org.grupoppai.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;


public class GestorRtaOperador {
    // Atributos por referencia del gestor.
    private Estado estado;
    private Cliente cliente;
    private CambioEstado cambioEstado;
    private Llamada llamada;
    private CategoriaLlamada categoriaSeleccionada;
    private OpcionLlamada opcionSeleccionada;
    private SubOpcionLlamada subOpcionSeleccionada;
    private PantallaRtaOperador pantallaRtaOperador; // PantallaRtaOperador, crea la dependencia entre el gestor y la pantalla.
    private List<Validacion> validaciones;
    private Session session;

    // Atributos por valor del gestor.
    private String nombreCliente;
    private String respuestaOperador;
    private List<String> datosCategoriaOpcionSubOpcion;
    private List<String> datosValidaciones;

    // Asignación de la pantalla al gestor para establecer la dependencia.
    public void setPantalla(PantallaRtaOperador pantallaRtaOperador) {
        this.pantallaRtaOperador = pantallaRtaOperador;
    }

    // Método que inicia la secuencia.
    public void nuevaRespuestaOperador(Llamada llamada, CategoriaLlamada categoriaSeleccionada, OpcionLlamada opcionSeleccionada, SubOpcionLlamada subOpcionSeleccionada, Session session) {

        // Guardamos la sesión para posteriormente actualizar la llamada en la base de datos.
        this.session = session;
        
        // Se cargan los datos de la llamada.
        recibirLlamada (llamada, categoriaSeleccionada, opcionSeleccionada, subOpcionSeleccionada);

        // Se hace que la llamada sea tomada por el operador.
        this.llamada.tomadaPorOperador(obtenerFechayHoraActual());

        // Se obtienen los datos de la llamada seleccionada.
        obtenerDatosLlamada(this.llamada, this.categoriaSeleccionada, this.opcionSeleccionada, this.subOpcionSeleccionada);

        // Se obtienen los mensajes de las validaciones.
        buscarValidaciones(this.opcionSeleccionada, this.subOpcionSeleccionada);
        
        // Se muestran los datos de la llamada y las validaciones en la pantalla.
        this.pantallaRtaOperador.mostrarDatosLlamadaYValidaciones(this.datosValidaciones, this.nombreCliente, this.datosCategoriaOpcionSubOpcion);
    }
    
    // Método para recibir los datos de la llamada.
    public void recibirLlamada (Llamada llamada, CategoriaLlamada categoriaSeleccionada, OpcionLlamada opcionSeleccionada, SubOpcionLlamada subOpcionSeleccionada) {
        this.llamada = llamada;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.opcionSeleccionada = opcionSeleccionada;
        this.subOpcionSeleccionada = subOpcionSeleccionada;

        // Se obtienen las validaciones de la base de datos para crear la dependencia entre el gestor y Validacion.
        this.obtenerValidacionesBBDD();
    }

    // Método para obtener la fecha y hora actual.
    public LocalDateTime obtenerFechayHoraActual(){
        return LocalDateTime.now();
    }
    
    // Método para obtener los datos de la llamada seleccionada.
    public void obtenerDatosLlamada(Llamada llamada, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        this.cliente = llamada.getCliente();
        this.nombreCliente = llamada.getNombreCompleto();
        this.datosCategoriaOpcionSubOpcion = categoriaSeleccionada.getDescripcionCompletaCategoriaYOpcion(opcionLlamada, subOpcionLlamada);
    }

    // Método encargado de obtener los mensajes de las validaciones.
    public void buscarValidaciones(OpcionLlamada opcionLlamada, SubOpcionLlamada subOpcionLlamada){
        // Se delega la responsabilidad a la categoría seleccionada.
        this.datosValidaciones = categoriaSeleccionada.buscarValidaciones(opcionLlamada, subOpcionLlamada);
    }

    // Método para obtener la validación seleccionada por el cliente y el dato a validar.
    public void tomarDatoValidacion (int validacion, String datoAValidar) {
        validarInformacionCliente (this.validaciones.get(validacion), datoAValidar);
    }

    // Método para validar la información ingresada por el cliente.
    public void validarInformacionCliente (Validacion validacion, String datoAValidar) {
        // Se delega la responsabilidad de validar al cliente seleccionado.
        if (this.cliente.esInformacionCorrecta (validacion, datoAValidar)) {
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

    // Método encargado de finalizar la llamada.
    public void finalizarLlamada(){
        this.llamada.finalizarLlamada(obtenerFechayHoraActual());
    }

    // Método encargado de finalizar el caso de uso.
    public void finCU() {
        // Se actualiza la llamada en la base de datos con la respuesta del operador, la duración y el nuevo estado.
        this.guardarDatosEnBBDD();

        System.out.println("Fin CU.");
    }

    // Método para obtener las validaciones de la BBDD.
    private void obtenerValidacionesBBDD() {
        this.validaciones = this.session.createQuery("FROM Validacion", Validacion.class).getResultList();
    }

    // Método para invocar la clase de fabricación pura que guarda los datos en la BBDD.
    private void guardarDatosEnBBDD() {
        Persistencia.persistirObjetos(this.session, this.llamada);
    }
}