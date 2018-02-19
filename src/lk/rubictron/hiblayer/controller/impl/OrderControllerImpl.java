/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.rubictron.hiblayer.controller.OrderController;
import lk.rubictron.hiblayer.core.OrderItem;
import lk.rubictron.hiblayer.core.Orders;
import lk.rubictron.hiblayer.dto.OrderDTO;
import lk.rubictron.hiblayer.dto.OrderDetailsDTO;
import lk.rubictron.hiblayer.service.CustomerService;
import lk.rubictron.hiblayer.service.ItemService;
import lk.rubictron.hiblayer.service.OrderService;
import lk.rubictron.hiblayer.service.impl.CustomerServiceImpl;
import lk.rubictron.hiblayer.service.impl.ItemServiceImpl;
import lk.rubictron.hiblayer.service.impl.OrderServiceImpl;
import lk.rubictron.hiblayer.view.controller.OrderViewController;

/**
 *
 * @author rubictron
 */
public class OrderControllerImpl implements OrderController {

    OrderService orderService = new OrderServiceImpl();
    ItemService itemService = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public boolean placeOrder(OrderDTO Dto, List<OrderDetailsDTO> details) {

        try {
            Orders orders = new Orders();
            orders.setTotal(Dto.getTotalPrice());
            orders.setDate(parseDate(Dto.getDate()));
            orders.setCustomer(customerService.getByIdCustomer(Dto.getCustomerId()));

            ArrayList<OrderItem> ordersArray = new ArrayList<>();

            details.forEach((t) -> {
                try {
                    OrderItem oi = new OrderItem();

                    oi.setItem(itemService.getByIdItem(t.getItemId()));
                    oi.setOrders(orders);
                    oi.setQuantity(t.getQuantity());
                    ordersArray.add(oi);

                } catch (Exception ex) {
                    Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            orderService.placeOrder(orders, ordersArray);

        } catch (Exception ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private java.sql.Date parseDate(String date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date utilDate = sdf.parse(date);
        return new java.sql.Date(utilDate.getTime());

    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        ArrayList<Orders> order = orderService.getAll();
        ArrayList<OrderDTO> orderDto = new ArrayList<OrderDTO>();

        order.forEach((t) -> {
            orderDto.add(new OrderDTO(t.getId(), String.valueOf(t.getDate()), t.getCustomer().getId(), t.getTotal()));

        });

        return orderDto;

    }
}
