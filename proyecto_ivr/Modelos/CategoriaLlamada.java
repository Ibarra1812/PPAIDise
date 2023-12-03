package Modelos;


import java.util.ArrayList;


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

    //Metodo encargado de buscar validaciones.
    public ArrayList<Validacion> buscarValidaciones(){
        
        //Buscar las validaciones en las subOpciones.
        return opcionLlamada.buscarValidaciones();
        
    }
    
    
}
