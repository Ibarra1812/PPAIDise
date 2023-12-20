package org.grupoppai.Persistencia;

import org.grupoppai.Modelos.CambioEstado;
import org.grupoppai.Modelos.Llamada;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Persistencia {

    /* Método invocado por el gestor para persistir objetos.

        Se podrían haber creado más clases de fabricación pura para persistir los objetos, pero
        como todos los objetos se pueden obtener a partir de la llamada seleccionada, para la
        persistencia, se utiliza esta única clase.

        Los nuevos objetos que se guardan son los estados concretos (EnCurso, Finalizada) y los cambios
        de estado que crean dichos estados concretos.

        Los objetos que se actualizan (ya presentes previamente en la BBDD) son la llamada seleccionada
        (para insertar su duración y la respuesta del operador) y el cambio de estado inicial (para setear
        su fecha y hora de fin).

     */
    public static void persistirObjetos(Session session, Llamada llamada) {
        Transaction transaction = session.beginTransaction();
        System.out.println("PUNTO 1");

        try {
            List<CambioEstado> cambios = llamada.getCambioEstado();

            for (int i = 0; i < cambios.size(); i++) {

                if (i == 0) {
                    session.update(cambios.get(i));
                } else {

                    session.persist(cambios.get(i).getEstado());
                    System.out.println("PUNTO 2");

                    session.persist(cambios.get(i));
                    System.out.println("PUNTO 3");
                }
            }

            session.update(llamada);
            System.out.println("PUNTO 4");

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}