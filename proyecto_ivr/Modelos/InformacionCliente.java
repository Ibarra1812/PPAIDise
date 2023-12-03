package Modelos;


public class InformacionCliente {

    private OpcionValidacion opcionValidacion;
    private Validacion validacion;
    private String datoAvalidacion;

    public InformacionCliente(OpcionValidacion opcionValidacion, Validacion validacion) {
        this.opcionValidacion = opcionValidacion;
        this.validacion = validacion;
    }

    public OpcionValidacion getOpcionValidacion() {
        return opcionValidacion;
    }

    public void setOpcionCorrecta(OpcionValidacion opcionCorrecta) {
        this.opcionValidacion= opcionValidacion;
    }

    public Validacion getValidacion() {
        return validacion;
    }

    public void setValidacion() {
        this.validacion = validacion;
    }

    public String getDatoAvalidar() {
        return datoAvalidacion;
    }

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
    }

    public void setDatoAvalidar(String datoAvalicion) {
        this.datoAvalidacion = datoAvalidacion;
    }


    
        /*
    Metodo #26
   Comprueba que sea la validacion de la llamada
    */
    public boolean esValidacion(Validacion validacion){
        if(this.validacion == validacion){
            return true;
        }
        return false;
    
    }
    /*
      
    Metodo #27
   Comprueba que sea la validacion correspondiente de la llamada
    */
    public boolean esInformacionCorrecta(String datoValidacion){
        
        return opcionValidacion.esCorrecta(datoValidacion);
        
    
    }
    
    
    
}
