
public class CategoriaLlamada {

    private String nombreCategoria;
    private int nroOrden;
    private OpcionLlamada opcionLlamada;

    public CategoriaLlamada(String nombreCategoria, int nroOrden, OpcionLlamada opcionLlamada) {
        this.nombreCategoria = nombreCategoria;
        this.nroOrden = nroOrden;
        this.opcionLlamada = opcionLlamada;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public OpcionLlamada getOpcionLlamada() {
        return opcionLlamada;
    }
    
    public String buscarValidaciones(OpcionLlamada opcionLlamada){
        return opcionLlamada.buscarValidaciones(opcionLlamada.getSubOpcionLlamada());
        
    }
    
    
}
