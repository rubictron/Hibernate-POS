/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo.impl;

import static com.sun.deploy.util.SessionState.save;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.rubictron.hiblayer.configuration.HibernateConfig;
import lk.rubictron.hiblayer.core.Item;
import lk.rubictron.hiblayer.core.OrderItem;
import lk.rubictron.hiblayer.core.Orders;
import lk.rubictron.hiblayer.repo.CustomerRepo;
import lk.rubictron.hiblayer.repo.ItemRepo;
import lk.rubictron.hiblayer.repo.OrderRepo;
import lk.rubictron.hiblayer.service.ItemService;
import lk.rubictron.hiblayer.service.impl.ItemServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rubictron
 */
public class OrderRepoImpl implements OrderRepo{
    
     SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    
    ItemRepo itemRepoImpl=new ItemRepoImpl();
    ItemService itemService=new ItemServiceImpl();
    

    @Override
    public boolean placeOrder(Orders order, ArrayList<OrderItem> orderItem) throws Exception{
       
        
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();

        
       orderItem.forEach((t) -> {
               t.getItem().setQuantity(t.getItem().getQuantity()-t.getQuantity());
                openSession.save(t);     
       }); 
  
        transaction.commit();
        openSession.close();
            return true;
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        Session openSession = sessionFactory.openSession();
        ArrayList<Orders> orders = (ArrayList<Orders>) openSession.createCriteria(Orders.class).list();
        openSession.close();
        return orders;
    }

}
