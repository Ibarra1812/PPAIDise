package org.grupoppai;

import org.grupoppai.Controlador.GestorRtaOperador;
import org.grupoppai.Modelos.CategoriaLlamada;
import org.grupoppai.Modelos.Llamada;
import org.grupoppai.Modelos.OpcionLlamada;
import org.grupoppai.Modelos.SubOpcionLlamada;
import org.grupoppai.Vista.PantallaRtaOperador;
import org.grupoppai.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String []args) {

        // Se crean los objetos de fabricación pura.
        GestorRtaOperador gestorRtaOperador = new GestorRtaOperador();
        PantallaRtaOperador pantallaRtaOperador = new PantallaRtaOperador(gestorRtaOperador);
        gestorRtaOperador.setPantalla(pantallaRtaOperador);

        /*
            Se obtienen la llamada, la categoría, la opción y la subopción seleccionadas por el cliente.
            Estos datos serían enviados por el CU Registrar Llamada. En este caso, realizamos las consultas
            a la base de datos. En la base de datos existe una llamada registrada (que sería la llamada
            que inició el cliente).
         */

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Llamada llamada = session.createQuery("FROM Llamada", Llamada.class).getResultList().get(0);
        CategoriaLlamada categoriaSeleccionada = session.createQuery("FROM CategoriaLlamada", CategoriaLlamada.class).getResultList().get(0);
        OpcionLlamada opcionSeleccionada = session.createQuery("FROM OpcionLlamada", OpcionLlamada.class).getResultList().get(0);
        SubOpcionLlamada subOpcionSeleccionada = session.createQuery("FROM SubOpcionLlamada", SubOpcionLlamada.class).getResultList().get(0);

        gestorRtaOperador.nuevaRespuestaOperador(llamada,categoriaSeleccionada, opcionSeleccionada, subOpcionSeleccionada, session);
    }
}
