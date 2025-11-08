package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionPool {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public static void stop() {
        factory.close();
        System.out.println("Factory Close");
    }

    public static Session get() {
       return factory.openSession();
    }


}
