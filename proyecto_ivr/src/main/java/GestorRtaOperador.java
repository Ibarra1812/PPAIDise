
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorRtaOperador {
    private PantallaRtaOperador pantalla;
    private Estado estado;
    private Cliente cliente;
    private CambioEstado cambioEstado;
    private Llamada llamada;
    private CategoriaLlamada categoriaLlamada;
    private pantallaPrueba p2;

    public void setPantalla(pantallaPrueba p2) {
        this.p2 = p2;
        p2.habilitarVentana();
    }
    
    public void nuevaRespuestaOperador(Llamada llamada){
        
        recibirLlamada(llamada);
        
        llamada.tomadaPorOperador(buscarEstadoEnCurso());
        
        obtenerDatosLlamada();
       
        
        p2.mostrarDatosLlamadayValidaciones();
        
        
    }
    public void recibirLlamada(Llamada llamada){
       
        
        this.llamada = llamada;
        
         
        
    }

    
    
    
    public Estado buscarEstadoEnCurso(){
        //estados para setear en caso de prueba
        Estado estadoPrueba_2 = new Estado("Iniciada");
        Estado estadoPrueba_3 = new Estado("Finalizada");
        Estado estadoPrueba_1 = new Estado("EnCurso");
        ArrayList<Estado> ArrayEstados = new ArrayList<Estado>(3);
        ArrayEstados.add(estadoPrueba_1);
        ArrayEstados.add(estadoPrueba_2);
        ArrayEstados.add(estadoPrueba_3);
        
        
        
        for (int i=0; i<ArrayEstados.size();i++){
            Estado estadoComparacion = ArrayEstados.get(i);
            if(estadoComparacion.esEnCurso(estadoComparacion) == true){
                return estadoComparacion;
            } 
        }
        return null;
        
        
    }
     public String obtenerDatosCategoria(){
        
        return categoriaLlamada.getNombreCategoria();
        
    }
    public String[] obtenerDatosLlamada(){
        CategoriaLlamada categoriaPrueba = new CategoriaLlamada("Informar robo", 1, llamada.getOpcionLlamada());
        
        String datos[];
        datos = new String[4];
        
        datos[0] = llamada.getNombreCompleto();
        datos[1] = categoriaPrueba.getNombreCategoria();
        datos[2] = llamada.getOpcionLlamada().getNombreOpcionLlamada();
        datos[3] = llamada.getSubOpcionLlamada().getNombre();
        
        
        
        return datos;
        
        
    
    }
    
    
    public String buscarValidaciones(){
        CategoriaLlamada categoriaPrueba = new CategoriaLlamada("Informar robo", 1, llamada.getOpcionLlamada());

        
        
        return categoriaPrueba.buscarValidaciones(categoriaPrueba.getOpcionLlamada());
       
    }
    
    public void tomarDatoValidacion(){
    
        p2.tomarIngresoDatoValidacion();
        validarInformacionCliente();
        
    }
    
    
    public boolean validarInformacionCliente(){
        
        
        if(llamada.getCliente().esInformacionCorrecta() == true){
            return true;
        }
        return false;
        
        
    
    }
    public void tomarRtaOperador(){}
    public void tomarConfirmacion(){}
    public void finalizarLlamada(){}
    public void obtenerFechayHora(){}
    public void buscarEstadoFinalizada(){}
    
}
