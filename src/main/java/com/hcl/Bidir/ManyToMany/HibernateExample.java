package com.hcl.Bidir.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {
        // Load hibernate.cfg.xml configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        // Add annotated classes explicitly (optional if configured in XML)
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Project.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create employees
        Employee emp1 = new Employee("ANKIT");
        Employee emp2 = new Employee("SHIVA");

        // Create projects
        Project project1 = new Project("IT");
        Project project2 = new Project("HR");

        // Establish many-to-many relationship
        emp1.addProject(project1);
        emp1.addProject(project2);

        emp2.addProject(project1);

        // Save projects and employees (cascade = ALL will save related entities)
        session.save(emp1);
        session.save(emp2);
        // Note: save of projects not necessary because of cascade but explicit save is OK too
        // session.save(project1);
        // session.save(project2);

        tx.commit();

        // Fetch employee and print projects
        Employee foundEmployee = session.get(Employee.class, emp2.getId());
        System.out.println("Employee: " + foundEmployee.getName());
        for (Project project : foundEmployee.getProjects()) {
            System.out.println("Assigned project: " + project.getName());
        }

        session.close();
        factory.close();
    }
}
