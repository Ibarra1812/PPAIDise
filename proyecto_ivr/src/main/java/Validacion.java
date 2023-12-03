
public class Validacion {
    private String nombre;
    private OpcionValidacion opcionValidacion;

    public Validacion(String nombre, OpcionValidacion opcionValidacion) {
        this.nombre = nombre;
        this.opcionValidacion = opcionValidacion;
    }

   public String getMensajeValidacion(){
       return nombre;
   }

    public OpcionValidacion getOpcionValidacion() {
        return opcionValidacion;
    }
    
   
}
