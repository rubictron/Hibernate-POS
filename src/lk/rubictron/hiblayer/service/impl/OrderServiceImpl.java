/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.service.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.rubictron.hiblayer.core.OrderItem;
import lk.rubictron.hiblayer.core.Orders;
import lk.rubictron.hiblayer.repo.CustomerRepo;
import lk.rubictron.hiblayer.repo.ItemRepo;
import lk.rubictron.hiblayer.repo.OrderRepo;
import lk.rubictron.hiblayer.repo.impl.CustomerRepoImpl;
import lk.rubictron.hiblayer.repo.impl.ItemRepoImpl;
import lk.rubictron.hiblayer.repo.impl.OrderRepoImpl;
import lk.rubictron.hiblayer.service.OrderService;

/**
 *
 * @author rubictron
 */
public class OrderServiceImpl implements OrderService{
    
    OrderRepo orderRepo=new OrderRepoImpl();

    public OrderServiceImpl() {
    }

    
    
    @Override
    public boolean placeOrder(Orders order, ArrayList<OrderItem> orderItem) {
       
        try {
            orderRepo.placeOrder(order, orderItem);
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
       return orderRepo.getAll();
    }

    
}
