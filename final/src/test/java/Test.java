
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
import config.HibernateConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String []args){

        // GestorRtaOperador gestorRtaOperador = new GestorRtaOperador();
        // PantallaRtaOperador pantallaRtaOperador = new PantallaRtaOperador(gestorRtaOperador);
        // gestorRtaOperador.setPantalla(pantallaRtaOperador);

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Llamada> llamadas = session.createQuery("FROM Llamada", Llamada.class).getResultList();
        System.out.println("Llamadas");
        System.out.println(llamadas);


        session.close();
        
        
    
    }
}
