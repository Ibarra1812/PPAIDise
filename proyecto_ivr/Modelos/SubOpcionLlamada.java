package Modelos;


import java.util.ArrayList;


public class SubOpcionLlamada {
    private String nombre;
    private int nroOrden;
    private ArrayList<Validacion> validacion;

    public SubOpcionLlamada(String nombre, int nroOrden, ArrayList<Validacion> validacion) {
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.validacion = validacion;
    }

    

    public String getNombre() {
        return nombre;
    }

    
    //Metodo encargado de buscar validaciones
    public ArrayList<Validacion> buscarValidaciones() {
        
        //Devuelve la validacion requerida por las opciones seleccionadas por el cliente.
        return validacion;
    }
    
    
    

    
    
    
}
