
import java.util.ArrayList;


public class Test {
    public static void main(String []args){
        
        //creamos un objeto de tipo gestor.
        GestorRtaOperador gestor = new GestorRtaOperador();
        //creamos un objeto de tipo pantalla.
        PantallaRtaOperador pantalla = new PantallaRtaOperador(gestor);
        pantallaPrueba p2 = new pantallaPrueba(gestor);
        //creamos un objeto de tipo conexion, para conectar con la base de datos.
        //CConexion objetoConexion = new CConexion();
        
        //al objeto gestor le asociamos la pantalla
        gestor.setPantalla(p2);
       
        
        
        //Creamos los estados que va a tener la llamada.       
        Estado estadoPrueba_2 = new Estado("Iniciada");
        Estado estadoPrueba_3 = new Estado("Finalizada");
        Estado estadoPrueba_1 = new Estado("EnCurso");
        
        //Creamos un arreglo de tipo Estado que contenga los estados.
        ArrayList<Estado> ArrayEstados = new ArrayList<Estado>(3);
        
        //usamos add para ingresar los al arreglo.
        ArrayEstados.add(estadoPrueba_1);
        ArrayEstados.add(estadoPrueba_2);
        ArrayEstados.add(estadoPrueba_3);
        
        //Creamos es cambio estado correspondiente a la llamada inicial.
        
        CambioEstado camEstadoPrueba = new CambioEstado("2018-02-27T8:15:32.107",estadoPrueba_2);
        
        //Creamos objetos de topo opcion, categoria y sub opcion para la ejecucion del CU
        OpcionValidacion opcionValidacionPrueba = new OpcionValidacion("04/08/1999","Fecha de nacimiento");
        
        
        
        
        
        
        Validacion validacionPrueba = new Validacion("Fecha De Nacimiento", opcionValidacionPrueba );
        SubOpcionLlamada subOpcionPrueba = new SubOpcionLlamada("Cuenta con los datos de la tarjeta", 1,validacionPrueba);
        OpcionLlamada opcionPrueba = new OpcionLlamada("Informar robo y solicitar tarjeta", 1,subOpcionPrueba);
        
 
        //creamos un cliente para la ejecucion del CU.
        InformacionCliente infoCliente = new InformacionCliente(opcionValidacionPrueba, validacionPrueba);
        Cliente clientePrueba = new Cliente("41001355","Nicolas Campos","3467438225",infoCliente);
        
        //Creamos una llamada para la ejecucion del CU.
        Llamada llamadaPrueba = new Llamada(clientePrueba, estadoPrueba_2, opcionPrueba, subOpcionPrueba, camEstadoPrueba);
        
        
        gestor.nuevaRespuestaOperador(llamadaPrueba);
        gestor.tomarDatoValidacion();
        p2.permitirIngresoDatoOperador();
        
        
        
        
    
    }
}
