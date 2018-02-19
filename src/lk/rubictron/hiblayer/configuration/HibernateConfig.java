/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author rubictron
 */
public class HibernateConfig {
  

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
             return new Configuration().configure().buildSessionFactory();
        } catch (Throwable t) {
            throw new ExceptionInInitializerError();
        }
       
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutDown(){
        getSessionFactory().close();
    }


    
}
