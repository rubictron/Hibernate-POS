/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller.impl;

import java.util.ArrayList;
import lk.rubictron.hiblayer.controller.ItemController;
import lk.rubictron.hiblayer.core.Item;
import lk.rubictron.hiblayer.dto.ItemDTO;
import lk.rubictron.hiblayer.service.ItemService;
import lk.rubictron.hiblayer.service.impl.ItemServiceImpl;

/**
 *
 * @author rubictron
 */
public class ItemControllerImpl implements ItemController {
    
    ItemService service = new ItemServiceImpl();
    
    @Override
    public boolean add(ItemDTO t) throws Exception {
        Item item = new Item();
        item.setName(t.getName());
        item.setQuantity(t.getQuantity());
        item.setUnitPrice(t.getUnitPrice());
        
        return service.addItem(item);
        
    }
    
    @Override
    public boolean update(ItemDTO t) throws Exception {
        Item item = new Item();
        item.setId(t.getId());
        item.setName(t.getName());
        item.setQuantity(t.getQuantity());
        item.setUnitPrice(t.getUnitPrice());
        
        return service.updateItem(item);
    }
    
    @Override
    public boolean delete(int id) throws Exception {
      return service.deleteItem(id);
    }
    
    @Override
    public ItemDTO getById(int id) throws Exception {
        
        Item item=service.getByIdItem(id);
        return new ItemDTO(item.getId(),item.getName(),item.getQuantity(),item.getUnitPrice());
    }
    
    @Override
    public ArrayList<ItemDTO> search(String id) throws Exception {
        ArrayList<ItemDTO> itemsDto=new ArrayList<>();
        ArrayList<Item> items = service.searchItem(id);
        
        items.forEach((item) -> {
           
            itemsDto.add(new ItemDTO(item.getId(),item.getName(),item.getQuantity(),item.getUnitPrice()));
            
        });
        
        return itemsDto;
    }
    
    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
         ArrayList<ItemDTO> itemsDto=new ArrayList<>();
        ArrayList<Item> items = service.getAllItem();
        
        items.forEach((item) -> {
           
            itemsDto.add(new ItemDTO(item.getId(),item.getName(),item.getQuantity(),item.getUnitPrice()));
            
        });
        
        return itemsDto;
    }
    
}
