
public class SubOpcionLlamada {
    private String nombre;
    private int nroOrden;
    private Validacion validacion;

    public SubOpcionLlamada(String nombre, int nroOrden, Validacion validacion) {
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.validacion = validacion;
    }

    

    public String getNombre() {
        return nombre;
    }

    public String getMensajeValidacion() {
        return validacion.getMensajeValidacion();
    }
    
    
    

    
    
    
}
