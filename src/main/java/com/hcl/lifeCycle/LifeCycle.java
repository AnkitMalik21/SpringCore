package com.hcl.lifeCycle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifeCycle {

    public static void main(String[] args) {

        // Create Hibernate SessionFactory from hibernate.cfg.xml configuration file
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Transient State: Create entity instance (not yet associated with Hibernate session)
        Employee employee = new Employee();
        employee.setId(1);  // Make sure your DB allows this ID or use proper generation strategy
        employee.setName("ankit sir");
        employee.setDepartment("IT");

        Session session = null;
        Transaction tx = null;

        try {
            // Persistent State: Open session and save entity
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(employee);

            tx.commit();
            session.close();  // Detach entity here
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Detached State: modify entity detached from session
        employee.setName("shiva");

        try {
            // Reattach entity using update() in a new session
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.update(employee);  // Reattaches the detached entity

            tx.commit();
            session.close();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        try {
            // Removed State: delete the entity in new session
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.delete(employee);   // Deletes entity from DB

            tx.commit();
            session.close();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Closing SessionFactory after all work is done
        sessionFactory.close();
    }
}
