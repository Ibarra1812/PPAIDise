package org.grupoppai.Modelos;


import org.grupoppai.Patrones.Iterator.Implementaciones.IteradorInformacionCliente;
import org.grupoppai.Patrones.Iterator.Interfaces.IAgregado;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements IAgregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombreCompleto;
    private String nroCelular;
    @OneToMany
    private List<InformacionCliente> infoCliente;

    public Cliente(String dni, String nombreCompleto, String nroCelular, List<InformacionCliente> infoCliente) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
        this.infoCliente = infoCliente;
    }

    public Cliente() {

    }

    //Metodo encargado de obtener el nombre completo del cliente.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //Metodo encargado de corroborar que sea una validacion valida y que el dato a validar sea correcto.
    /*
    public boolean esInformacionCorrecta(String datoValidacion){
        
        //Condicionar encargado de corroborar sea una validacion valida y la informacion sea correcta. 
        return (infoCliente.esValidacion(infoCliente.getValidacion()) && infoCliente.esInformacionCorrecta(datoValidacion));

    }
     */

    public boolean esInformacionCorrecta (Validacion val, String datoValidacion) {

        // Se crea la lista de filtros y se agrega el filtro necesario.
        List<Object> filtros = new ArrayList<>();
        filtros.add(val);

        // Se crea el iterador.
        IteradorInformacionCliente iteradorInformacionCliente = new IteradorInformacionCliente(this.infoCliente, filtros);

        // Seteamos el índice en la posición inicial.
        iteradorInformacionCliente.primero();

        // Se verifica que la iteración no haya finalizado.
        while ( !iteradorInformacionCliente.haTerminado() ) {

            // Se obtiene el elemento actual de la iteración.
            InformacionCliente infoCliente = iteradorInformacionCliente.actual();

            // Si el objeto cumple el filtro (no es nulo), se le pregunta si la información es correcta.
            if (infoCliente != null) {
                return infoCliente.esInformacionCorrecta(datoValidacion);
            }

            // Incrementamos la posición del índice.
            iteradorInformacionCliente.siguiente();
        }
        return false;
    }

    @Override
    public IIterador crearIterador(List elementos, List filtros) {
        return new IteradorInformacionCliente (elementos, filtros);
    }
}
