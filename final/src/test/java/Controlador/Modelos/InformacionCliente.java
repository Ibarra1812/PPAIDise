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


    
    //Metodo encargado de comprobar la validacion
    public boolean esValidacion(Validacion validacion){
        //Condicional encargado de combroba que la validacion sea correcta.
        if(this.validacion == validacion){
            return true;
        }
        return false;
    
    }

    //Metodo encargar de corroborar que la opcion sea la correcta.
    public boolean esInformacionCorrecta(String datoValidacion){
        
        return opcionValidacion.esCorrecta(datoValidacion);
        
    
    }
    
    
    
}
