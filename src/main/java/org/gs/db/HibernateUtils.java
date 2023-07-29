package org.gs.db;

import org.flywaydb.core.Flyway;
import org.gs.entity.Client;
import org.gs.entity.Planet;
import org.gs.entity.Ticket;
import org.gs.props.PropertiesUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE = new HibernateUtils();
    private final SessionFactory sessionFactory;
    private static final String DB_URL_KEY = "hibernate.connection.url";
    private static final String DB_USER_KEY = "hibernate.connection.username";
    private static final String DB_PASSWORD_KEY = "hibernate.connection.password";


    private HibernateUtils() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        flywayMigration(
                PropertiesUtil.getPropertyValue(DB_URL_KEY),
                PropertiesUtil.getPropertyValue(DB_USER_KEY),
                PropertiesUtil.getPropertyValue(DB_PASSWORD_KEY)
        );
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }

    private void flywayMigration(String dbConnectionUrl, String username, String password) {
        Flyway flyway = Flyway.configure().dataSource(dbConnectionUrl, username, password).load();
        flyway.migrate();
    }
}