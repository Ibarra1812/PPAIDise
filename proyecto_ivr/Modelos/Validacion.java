package Modelos;


import java.util.ArrayList;


public class Validacion {
    private String nombre;
    private ArrayList<OpcionValidacion> opcionValidacion;

    public Validacion(String nombre, ArrayList<OpcionValidacion> opcionValidacion) {
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
    public ArrayList<OpcionValidacion> getOpcionValidacion() {
        return opcionValidacion;
    }
    
   
}
