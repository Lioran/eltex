package com.ex;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
/**
 *Класс с CRUD-операциями
 * @author Dmitrii
 * @version 1.0
 */
public class AbonentInPhoneBook {
    /**
     * Функция поиска абонента по заданому индитификатору
     * @param id - индитификатор
     * @return - абонент
     */
    public Abonent findById(int id){
        return HibernateSession.getSessionFactory().openSession().get(Abonent.class, id);
    }

    /**
     * Функция сохранения абонента в базу данных
     * @param abonent - абонент
     */
    public void save(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(abonent);
        transaction.commit();
        session.close();
    }

    /**
     * Функция удаления абонента из базы данных
     * @param abonent - абонент
     */
    public void delete(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(abonent);
        transaction.commit();
        session.close();
    }

    /**
     * Функция обновления данных об абоненте в базу данных
     * @param abonent - абонент
     */
    public void update(Abonent abonent) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(abonent);
        transaction.commit();
        session.close();
    }

    /**
     * Функция вывода всех абонентов из базы данных
     * @return список абонентов
     */
    public List<Abonent> getAllAbonent() {
        return HibernateSession.getSessionFactory().openSession().createQuery("FROM Abonent", Abonent.class).list();
    }
}