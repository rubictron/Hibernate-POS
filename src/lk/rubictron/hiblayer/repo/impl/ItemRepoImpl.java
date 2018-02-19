/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo.impl;

import java.io.Serializable;
import java.util.ArrayList;
import lk.rubictron.hiblayer.configuration.HibernateConfig;
import lk.rubictron.hiblayer.core.Item;
import lk.rubictron.hiblayer.repo.ItemRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rubictron
 */
public class ItemRepoImpl implements ItemRepo{

    

    
    
    
     SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    
    @Override
    public boolean add(Item t) throws Exception {

        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        Serializable save = openSession.save(t);
        transaction.commit();
        openSession.close();

        return save != null;

    }

    @Override
    public boolean update(Item t) throws Exception {
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
    public Item getById(int id) throws Exception {
        Session openSession = sessionFactory.openSession();
        ArrayList<Item> items = (ArrayList<Item>) openSession.createQuery("from Item i where i.id=" + id).list();
        openSession.close();
        if (items == null) {
            System.out.println("null");
            return null;
        } else {
            return items.get(0);
        }
    }

    @Override
    public ArrayList<Item> search(String id) throws Exception {
         Session openSession = sessionFactory.openSession();
        openSession = sessionFactory.openSession();
        ArrayList<Item> items = (ArrayList<Item>) openSession.createQuery("from Item i where i.id like '%" + id + "%' or i.name like '%" + id + "%'").list();
        openSession.close();
        return items;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
      Session openSession = sessionFactory.openSession();
        ArrayList<Item> item = (ArrayList<Item>) openSession.createCriteria(Item.class).list();
        openSession.close();
        return item;
    }
    
    
    
}
