package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SessionPool {
    private static final int POOL_SIZE = 20;
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private static final BlockingQueue<Session> pool = new ArrayBlockingQueue<>(POOL_SIZE);

    private static final List<Session> realSessions = new ArrayList<>();

    static {
        for (int i = 0; i <POOL_SIZE ; i++) {
            Session session = factory.openSession();
            pool.add((Session)Proxy.newProxyInstance(
                    SessionPool.class.getClassLoader(),
                    new Class<?>[]{Session.class},
                    ((proxy, method, args) -> {
                        if (method.getName().equals("close")) {
                            add((Session) proxy);
                            return null;
                        }
                        return method.invoke(session, args);
                    }))
            );
            realSessions.add(session);
        }
    }

    public static void stop() {
        closeSession();
        factory.close();
        System.out.println("Pool Close");
    }

    public static Session get() {
       return pool.poll();
    }

    private static void add(Session session) {
        pool.add(session);
    }

    private static void closeSession() {
        for (Session session : realSessions) {
            session.close();
        }
    }

}
