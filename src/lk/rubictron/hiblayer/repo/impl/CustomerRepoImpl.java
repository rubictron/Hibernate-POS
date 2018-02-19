/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo.impl;

import java.io.Serializable;
import java.util.ArrayList;
import lk.rubictron.hiblayer.configuration.HibernateConfig;
import lk.rubictron.hiblayer.core.Customer;
import lk.rubictron.hiblayer.repo.CustomerRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rubictron
 */
public class CustomerRepoImpl implements CustomerRepo {

    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public CustomerRepoImpl() {

    }

    @Override
    public boolean add(Customer t) throws Exception {

        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        Serializable save = openSession.save(t);
        transaction.commit();
        openSession.close();

        return save != null;

    }

    @Override
    public boolean update(Customer t) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        openSession.update(t);
        transaction.commit();
        openSession.close();
        return true;

    }

    @Override
    public boolean delete(int id) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();

        openSession.delete(getById(id));

        transaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public ArrayList<Customer> search(String id) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        openSession = sessionFactory.openSession();
        ArrayList<Customer> customers = (ArrayList<Customer>) openSession.createQuery("from Customer c where c.id like '%" + id + "%' or c.name like '%" + id + "%'").list();
         transaction.commit();
         openSession.close();
        return customers;

    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {

        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        ArrayList<Customer> customers = (ArrayList<Customer>) openSession.createCriteria(Customer.class).list();
        transaction.commit();
        openSession.close();
        return customers;

    }

    @Override
    public Customer getById(int id) throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        ArrayList<Customer> customers = (ArrayList<Customer>) openSession.createQuery("from Customer c where c.id ="+id).list();
         transaction.commit();
         openSession.close();
         
        if (customers == null) {
            System.out.println("null");
            return null;
        } else {
            System.out.println(customers.get(0).getId());
            return customers.get(0);
        }

    }


}
