package com.ex;

import com.ex.Abonent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.HibernateSession;

import java.util.ArrayList;
import java.util.List;

public class AbonentInPhoneBook {
    public Abonent findById(int id){
        return HibernateSession.getSessionFactory().openSession().get(Abonent.class, id);
    }

    public void save(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(abonent);
        tx1.commit();
        session.close();
    }

    public void delete(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(abonent);
        tx1.commit();
        session.close();
    }

    public void update(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(abonent);
        tx1.commit();
        session.close();
    }

    public List getAllAbonent() {
        return (List<Abonent>) HibernateSession.getSessionFactory().openSession().createQuery("FROM Abonent", Abonent.class).list();
    }
}