package Modelos;


public class OpcionValidacion {
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
