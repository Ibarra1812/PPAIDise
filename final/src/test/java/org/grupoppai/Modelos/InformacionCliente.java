package org.grupoppai.Modelos;


import javax.persistence.*;

@Entity
public class InformacionCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Validacion validacion;
    private String datoAValidar;

    public InformacionCliente(Validacion validacion) {
        this.validacion = validacion;
        this.datoAValidar = datoAValidar;
    }

    public InformacionCliente() {

    }

    public Validacion getValidacion() {
        return validacion;
    }

    public void setValidacion() {
        this.validacion = validacion;
    }

    /*
    public String getDatoAvalidar() {
        return datoAvalidacion;
    }
     */

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
    }

    //Metodo encargado de comprobar la validacion
    public boolean esValidacion(String validacion){
        //Condicional encargado de combroba que la validacion sea correcta.
        return this.validacion.esValidacion(validacion);
    
    }

    //Metodo encargar de corroborar que la opcion sea la correcta.
    public boolean esInformacionCorrecta(String datoValidacion){
        
        return this.datoAValidar.equals(datoValidacion);
        
    
    }
    
    
    
}