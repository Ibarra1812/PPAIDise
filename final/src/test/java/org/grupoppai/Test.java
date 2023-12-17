package org.grupoppai;

import org.grupoppai.Controlador.GestorRtaOperador;
import org.grupoppai.Modelos.CategoriaLlamada;
import org.grupoppai.Modelos.Llamada;
import org.grupoppai.Modelos.OpcionLlamada;
import org.grupoppai.Modelos.SubOpcionLlamada;
import org.grupoppai.Vista.PantallaRtaOperador;
import org.grupoppai.config.HibernateConfig;
import org.hibernate.Session;

import java.util.List;


public class Test {
    public static void main(String []args){

        GestorRtaOperador gestorRtaOperador = new GestorRtaOperador();
        PantallaRtaOperador pantallaRtaOperador = new PantallaRtaOperador(gestorRtaOperador);
        gestorRtaOperador.setPantalla(pantallaRtaOperador);

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Llamada> llamadas = session.createQuery("FROM Llamada", Llamada.class).getResultList();
        System.out.println(llamadas);

        List<CategoriaLlamada> categorias = session.createQuery("FROM CategoriaLlamada", CategoriaLlamada.class).getResultList();
        System.out.println(categorias);

        List<OpcionLlamada> opciones = session.createQuery("FROM OpcionLlamada", OpcionLlamada.class).getResultList();
        System.out.println(opciones);

        List<SubOpcionLlamada> subopciones = session.createQuery("FROM SubOpcionLlamada", SubOpcionLlamada.class).getResultList();
        System.out.println(subopciones);

        gestorRtaOperador.nuevaRespuestaOperador(llamadas.get(0), categorias.get(0), opciones.get(0), subopciones.get(0));
    }
}
