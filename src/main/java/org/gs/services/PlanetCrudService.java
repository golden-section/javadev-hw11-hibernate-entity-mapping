package org.gs.services;

import org.gs.db.HibernateUtils;
import org.gs.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PlanetCrudService {

    public void createPlanet(Planet planet) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Planet getPlanetById(String id) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updatePlanet(Planet planet) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePlanet(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if(planet !=null) {
                session.remove(planet);
                System.out.println("The planet with id [" + id + "] has been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Planet> getAllPlanets() {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Planet", Planet.class).list();
        }
    }
}