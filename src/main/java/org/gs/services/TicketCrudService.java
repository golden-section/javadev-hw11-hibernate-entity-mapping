package org.gs.services;

import org.gs.db.HibernateUtils;
import org.gs.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {

    public void createTicket(Ticket ticket) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Ticket getTicketById(long id) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            System.out.println("ticket by ID [" + id + "] = " + ticket);
            return ticket;
        }
    }

    public void updateTicket(Ticket ticket) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTicket(long id) {
        Transaction transaction = null;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if(ticket != null) {
                session.remove(ticket);
                System.out.println("The ticket with id [" + id + "] has been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getAllTickets() {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            List<Ticket> ticketList = session.createQuery("FROM Ticket", Ticket.class).list();
            ticketList.forEach(ticket -> System.out.println(ticket.toString()));
        }
    }
}