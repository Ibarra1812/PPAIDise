package org.grupoppai.Modelos;


import org.grupoppai.Patrones.Iterator.Implementaciones.IteradorInformacionCliente;
import org.grupoppai.Patrones.Iterator.Interfaces.IAgregado;
import org.grupoppai.Patrones.Iterator.Interfaces.IIterador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Anotación que indica que es una clase con persistencia.
@Entity
public class Cliente implements IAgregado { // Se implementa la interfaz IAgregado para aplicar el Iterator.

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos por valor de Cliente.
    private String dni;
    private String nombreCompleto;
    private String nroCelular;

    // Atributo por referencia de Cliente.
    @OneToMany
    private List<InformacionCliente> infoCliente;

    // Constructor sin parámetros.
    public Cliente() {
    }

    // Método encargado de obtener el nombre completo del cliente.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    // Método encargado de validar que la información ingresada por el usuario sea correcta.
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
                return infoCliente.esInformacionCorrecta(datoValidacion); // Se verifica que la información sea correcta.
            }

            // Incrementamos la posición del índice.
            iteradorInformacionCliente.siguiente();
        }
        return false;
    }

    // Método que implementa la interfaz IAgregado. Siempre se crea un iterador de información de cliente.
    @Override
    public IIterador crearIterador(List elementos, List filtros) {
        return new IteradorInformacionCliente (elementos, filtros);
    }
}
