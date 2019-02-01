package com.ex;

import com.ex.Abonent;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Класс создания сессии в Hibernate
 * @author Dmitrii
 * @version 1.0
 */
public class HibernateSession {
    /**
     * Поле сессии
     */
    private static SessionFactory sessionFactory;

    /**
     * Конструктор сессии
     */
    private HibernateSession(){};

    /**
     * Функция получения сессии {@link HibernateSession#sessionFactory}
     * @return сессию
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Abonent.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        return sessionFactory;
    }
}