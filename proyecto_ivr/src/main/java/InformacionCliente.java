
public class InformacionCliente {

    private OpcionValidacion opcionCorrecta;
    private Validacion validacion;
    private String datoAvalidar;

    public InformacionCliente(OpcionValidacion opcionCorrecta, Validacion validacion) {
        this.opcionCorrecta = opcionCorrecta;
        this.validacion = validacion;
    }

    public OpcionValidacion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(OpcionValidacion opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Validacion getValidacion() {
        return validacion;
    }

    public void setValidacion() {
        this.validacion = validacion;
    }


    
    
    public boolean esValidacion(){
        return true;
    
    }
    
    public boolean esInformacionCorrecta(){
        return true;
    
    }
    
    
    
}
