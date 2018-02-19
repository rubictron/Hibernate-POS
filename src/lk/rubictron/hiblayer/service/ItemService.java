/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.service;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Item;

/**
 *
 * @author rubictron
 */
public interface ItemService {
    
    boolean addItem(Item t) throws Exception;

    boolean updateItem(Item t) throws Exception;

    boolean deleteItem(int id) throws Exception;

    Item getByIdItem(int id) throws Exception;

    ArrayList<Item> searchItem(String id) throws Exception;

    ArrayList<Item> getAllItem() throws Exception;
    
}
