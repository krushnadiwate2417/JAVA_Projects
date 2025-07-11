package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student std = new Student(3,"Jagruti",21);
        Student std2 = null;

        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();

        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
//
//        session.persist(std);
//        transaction.commit();
          std2 = session.find(org.example.Student.class, 2);


        session.close();
        sf.close();
        System.out.println(std2);
    }
}