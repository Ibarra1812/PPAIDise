package org.grupoppai.Modelos;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Validacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    public Validacion(String nombre) {
        this.nombre = nombre;
    }

    public Validacion() {

    }

    public String getMensajeValidacion(){
       return nombre;
   }

    public boolean esValidacion(String validacion) {
        return Objects.equals(this.nombre, validacion);
    }

}
