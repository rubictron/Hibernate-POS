/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller;

import java.util.ArrayList;
import java.util.List;
import lk.rubictron.hiblayer.dto.OrderDTO;
import lk.rubictron.hiblayer.dto.OrderDetailsDTO;

/**
 *
 * @author rubictron
 */
public interface OrderController {
    public boolean placeOrder(OrderDTO Dto,List<OrderDetailsDTO> details);
     public ArrayList<OrderDTO> getAll() throws Exception;
}
