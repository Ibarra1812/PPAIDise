package org.grupoppai.config;

import org.grupoppai.Modelos.*;
import org.grupoppai.Patrones.State.Estado;
import org.grupoppai.Patrones.State.Implementaciones.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.SessionFactory;

import java.util.Properties;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Configuración de la base de datos.
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/ppai");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "Mari261103");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(properties);


                // Mapeo de las clases de entidad.
                configuration.addAnnotatedClass(CambioEstado.class);
                configuration.addAnnotatedClass(CategoriaLlamada.class);
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Estado.class);
                configuration.addAnnotatedClass(InformacionCliente.class);
                configuration.addAnnotatedClass(Llamada.class);
                configuration.addAnnotatedClass(OpcionLlamada.class);
                configuration.addAnnotatedClass(SubOpcionLlamada.class);
                configuration.addAnnotatedClass(Validacion.class);
                configuration.addAnnotatedClass(Iniciada.class);
                configuration.addAnnotatedClass(EnCurso.class);
                configuration.addAnnotatedClass(Finalizada.class);
                configuration.addAnnotatedClass(PendienteDeEscucha.class);
                configuration.addAnnotatedClass(Descartada.class);
                configuration.addAnnotatedClass(EscuchaConObservacion.class);
                configuration.addAnnotatedClass(EscuchaCorrecta.class);
                configuration.addAnnotatedClass(Cancelada.class);

                // Crear SessionFactory.
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}