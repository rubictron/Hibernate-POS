/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.service.impl;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Item;
import lk.rubictron.hiblayer.dto.ItemDTO;
import lk.rubictron.hiblayer.repo.ItemRepo;
import lk.rubictron.hiblayer.repo.impl.ItemRepoImpl;
import lk.rubictron.hiblayer.service.ItemService;

/**
 *
 * @author rubictron
 */
public class ItemServiceImpl implements ItemService{
    
    ItemRepo repo;

    public ItemServiceImpl() {
        repo=new ItemRepoImpl();
    }
    
    

    @Override
    public boolean addItem(Item t) throws Exception {
        return repo.add(t);
        
    }

    @Override
    public boolean updateItem(Item t) throws Exception {
        return repo.update(t);
    }

    @Override
    public boolean deleteItem(int id) throws Exception {
       return repo.delete(id);
    }

    @Override
    public Item getByIdItem(int id) throws Exception {
        return repo.getById(id);
    }

    @Override
    public ArrayList<Item> searchItem(String id) throws Exception {
       return repo.search(id);
    }

    @Override
    public ArrayList<Item> getAllItem() throws Exception {
       return repo.getAll();
    }
    
}
