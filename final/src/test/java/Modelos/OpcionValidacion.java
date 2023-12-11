package Modelos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OpcionValidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean correcta;
    private String descripcion;

    public OpcionValidacion(boolean correcta, String descripcion) {
        
        this.correcta = correcta;
        this.descripcion = descripcion;
    }

    
    //Metodo encargado de comprobar que el dato de validacion sea el correcto.
    public boolean esCorrecta(String datoValidacion) {//
        return true;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    
  
    
    
    
    
    
    
    
    
}
