
public class OpcionValidacion {
    private String correcta;
    private String descripcion;

    public OpcionValidacion(String correcta, String descripcion) {
        
        this.correcta = correcta;
        this.descripcion = descripcion;
    }

    
    
    public boolean esCorrecta() {
        return true;
    }


    public String getDescripcion() {
        return descripcion;
    }

    
    
    
    
    
}
