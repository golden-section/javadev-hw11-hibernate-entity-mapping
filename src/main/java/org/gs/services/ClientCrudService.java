package org.gs.services;

import org.gs.db.HibernateUtils;
import org.gs.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClientCrudService {

    public void createClient(Client client) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Client getClientById(long id) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void updateClient(Client client) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(session.merge(client));
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteClient(long id) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if(client != null) {
                session.remove(client);
                System.out.println("The client with id [" + id + "] has been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        }
    }
}