
public class Estado {
    private int idEstado;
    private String nombre;

    public Estado( String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esEnCurso(Estado estado){
        return "EnCurso".equals(estado.getNombre());
        
        
       
    }
    
    
}
