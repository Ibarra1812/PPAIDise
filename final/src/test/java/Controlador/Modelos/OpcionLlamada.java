package Modelos;


import java.util.ArrayList;


public class OpcionLlamada {

    private String nombreOpcionLlamada;
    private int nroOrden;
    private SubOpcionLlamada subOpcionLlamada;

    public OpcionLlamada(String nombreOpcionLlamada, int nroOrden, SubOpcionLlamada subOpcionLlamada) {
        this.nombreOpcionLlamada = nombreOpcionLlamada;
        this.nroOrden = nroOrden;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    

    public String getNombreOpcionLlamada() {
        return nombreOpcionLlamada;
    }

    public SubOpcionLlamada getSubOpcionLlamada() {
        return subOpcionLlamada;
    }
    
        /*
    Metodo #18
    Realiza la busqueda de la validaciones
    */
    public ArrayList<Validacion> buscarValidaciones(){
        return subOpcionLlamada.buscarValidaciones();
    }

    
    
    
    
}
