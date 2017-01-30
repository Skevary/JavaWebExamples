package com.github.skevary;

import com.github.skevary.entity.User;
import com.github.skevary.persistence.HibernateUtil;
import org.hibernate.Session;

public class EnterPoint {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setFirstName("John");
        user.setLastName("Smith");

        session.save(user);
        session.getTransaction().commit();
    }
}
