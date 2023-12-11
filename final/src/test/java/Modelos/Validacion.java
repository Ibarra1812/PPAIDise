package Modelos;


import javax.persistence.*;
import java.util.List;

@Entity
public class Validacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany
    private List<OpcionValidacion> opcionValidacion;

    public Validacion(String nombre, List<OpcionValidacion> opcionValidacion) {
        this.nombre = nombre;
        this.opcionValidacion = opcionValidacion;
    }

   public String getMensajeValidacion(){
       return nombre;
   }
   
      /*
    Metodo #20
    Realiza la obtencion de la validacion
    */
    public List<OpcionValidacion> getOpcionValidacion() {
        return opcionValidacion;
    }
    
   
}
