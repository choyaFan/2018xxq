package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();

    private static Configuration configuration = new Configuration().configure();

    static {
        buildSessionFactory();
    }

    private HibernateUtil(){}

    public static Session getSession()throws HibernateException{
        System.out.println("getSession");

        Session session = threadLocalSession.get();

        if(session == null || !session.isOpen()){
            if(sessionFactory == null) buildSessionFactory();
            //session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            if(sessionFactory != null) session = sessionFactory.openSession();
            else System.out.println("SessionFactory NULL!!!!!");
            threadLocalSession.set(session);
            if(session == null || !session.isOpen()) System.out.println("Session null!");
        }
        return session;
    }

    public static void closeSession()throws HibernateException{
        Session session = threadLocalSession.get();
        threadLocalSession.set(null);

        if(session != null) session.close();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Configuration getConfiguration(){
        return configuration;
    }

    private static void buildSessionFactory(){
        System.out.println("start build sessionFactory");

        if(configuration == null) configuration = new Configuration().configure();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        if(sessionFactory != null) System.out.println("factor build success");

    }
}
