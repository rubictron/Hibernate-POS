/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Item;
import lk.rubictron.hiblayer.dto.ItemDTO;

/**
 *
 * @author rubictron
 */
public interface ItemRepo {
    
     boolean add(Item t) throws Exception;

    boolean update(Item t) throws Exception;

    boolean delete(int id) throws Exception;

    Item getById(int id) throws Exception;

    ArrayList<Item> search(String id) throws Exception;

    ArrayList<Item> getAll() throws Exception;
    
}
