package myMainFiles;

import myEntity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import myUtil.HibernateUtil;

public class myApp {
    public static void main(String[] args) {
        Student s1 = new Student(111, "Neelanjan", "Hibernate", 91.0);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s1);

        tx.commit();
        session.close();

        System.out.println("Student saved successfully.");
    }
}

