package org.grupoppai.Modelos;

import javax.persistence.*;

// Anotación que indica que es una clase con persistencia.
@Entity
public class InformacionCliente {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributo por valor de InformacionCliente.
    private String datoAValidar;

    // Atributo por referencia de InformacionCLiente.
    @OneToOne
    private Validacion validacion;

    // Constructor sin parámetros.
    public InformacionCliente() {
    }

    // Método encargado de comprobar que la validación sea la ingresada por el cliente.
    public boolean esValidacion(Validacion validacion){
        return this.validacion == validacion;
    }

    // Método encargado de comprobar que la información ingresada sea correcta.
    public boolean esInformacionCorrecta(String datoValidacion){
        return this.datoAValidar.equals(datoValidacion);
    }
}