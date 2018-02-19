/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.OrderItem;
import lk.rubictron.hiblayer.core.Orders;

/**
 *
 * @author rubictron
 */
public interface OrderRepo {
    public boolean placeOrder(Orders order, ArrayList<OrderItem> orderItem) throws Exception;
    public ArrayList<Orders> getAll() throws Exception;
}
