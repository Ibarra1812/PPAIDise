package org.grupoppai.Modelos;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

// Anotación que indica que es una clase con persistencia.
@Entity
public class Validacion {

    // Atributo de persistencia en la BBDD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributo por valor de Validacion.
    private String nombre;

    // Constructor sin parámetros.
    public Validacion() {
    }

    // Método para obtener el mensaje de la validación.
    public String getMensajeValidacion(){
       return nombre;
   }
}