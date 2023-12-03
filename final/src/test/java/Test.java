
import Vista.PantallaRtaOperador;
import Controlador.GestorRtaOperador;
import Modelos.OpcionValidacion;
import Modelos.Cliente;
import Modelos.InformacionCliente;
import Modelos.SubOpcionLlamada;
import Modelos.CategoriaLlamada;
import Modelos.Validacion;
import Modelos.OpcionLlamada;
import Modelos.Llamada;
import Modelos.CambioEstado;
import Modelos.Estado;
import java.util.ArrayList;


public class Test {
    public static void main(String []args){
        
        //creamos un objeto de tipo gestor.
        GestorRtaOperador gestor = new GestorRtaOperador();
        
        //creamos un objeto de tipo pantalla.        
        PantallaRtaOperador PantallaRtaOperador = new PantallaRtaOperador(gestor);
        
        //al objeto gestor le asociamos la pantalla.
        gestor.setPantalla(PantallaRtaOperador);
       
                
        //Creamos los estados que va a tener la llamada.       
        Estado estadoPrueba_2 = new Estado("Iniciada");
        Estado estadoPrueba_3 = new Estado("Finalizada");
        Estado estadoPrueba_1 = new Estado("EnCurso");
        Estado estadoPrueba_4 = new Estado("Cancelada");
        
        //Creamos un arreglo de tipo Estado que contenga los estados.
        ArrayList<Estado> ArrayEstados = new ArrayList<Estado>(3);
        
        //usamos add para ingresar los al arreglo.
        ArrayEstados.add(estadoPrueba_1);
        ArrayEstados.add(estadoPrueba_2);
        ArrayEstados.add(estadoPrueba_3);
        ArrayEstados.add(estadoPrueba_4);
                
        
        //Creamos es cambio estado correspondiente a la llamada inicial.
        CambioEstado camEstadoPrueba = new CambioEstado(gestor.obtenerFechayHoraActual(),estadoPrueba_2);
        
        //Creamos un array de tipo CambioEstado con los cambios de estados que va a tener la pantalla.
        ArrayList<CambioEstado> cambiosEstado = new ArrayList<>();
        cambiosEstado.add(camEstadoPrueba);//Agregamos el primer cambio de estado al array.
        
        //Creamos objetos de OpcionValidacion que van a tener las opciones de la validacion con su opcion correcta.
        OpcionValidacion opcionValidacionPrueba = new OpcionValidacion(true,"15/12/1993");
        OpcionValidacion opcionValidacionPrueba_2 = new OpcionValidacion(false,"04/08/1999");
        OpcionValidacion opcionValidacionPrueba_3 = new OpcionValidacion(false,"26/12/1983");
        OpcionValidacion opcionValidacionPrueba_4 = new OpcionValidacion(false,"07/05/2002");
        
        //Crreamos un arrat de tipo opcion validacion para que cada validacion tenga sus opciones relacionadas
        ArrayList<OpcionValidacion> opcionesValidacion = new ArrayList<>();
        
        //Agregamos las opciones de validacion al Array creado.
        opcionesValidacion.add(opcionValidacionPrueba); 
        opcionesValidacion.add(opcionValidacionPrueba_2);
        opcionesValidacion.add(opcionValidacionPrueba_3);
        opcionesValidacion.add(opcionValidacionPrueba_4);
        
        //Creamos la validaion que vamos a comprobar.
        Validacion validacionPrueba = new Validacion("Fecha De Nacimiento", opcionesValidacion );

        //Al contar con varias validaciones, creamos un array para contenerlas.
        ArrayList<Validacion> validaciones = new ArrayList<>();
        validaciones.add(validacionPrueba);//La agregamos al array.
        
        //Creamos la categoria, opcion y subOpcion.
        SubOpcionLlamada subOpcionPrueba = new SubOpcionLlamada("Cuenta con los datos de la tarjeta", 1,validaciones);
        OpcionLlamada opcionPrueba = new OpcionLlamada("Informar robo y solicitar tarjeta", 1,subOpcionPrueba);
        CategoriaLlamada categoriaLlamada = new CategoriaLlamada("Informar robo", 1, opcionPrueba);

 
        //creamos un cliente y su informacion para la ejecuion del CU.
        InformacionCliente infoCliente = new InformacionCliente(opcionValidacionPrueba, validacionPrueba);
        Cliente clientePrueba = new Cliente("41001355","Nicolas Campos","3467438225",infoCliente);
        
        //Creamos una llamada para la ejecucion del CU.
        Llamada llamadaPrueba = new Llamada(clientePrueba, estadoPrueba_2, opcionPrueba, subOpcionPrueba,cambiosEstado);

        
        //Gestor que inicia la secuencia.
        gestor.nuevaRespuestaOperador(llamadaPrueba, categoriaLlamada, ArrayEstados);
        
        
        
        
        
        
        
        
        
        
    
    }
}
