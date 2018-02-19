/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller;

import java.util.ArrayList;
import lk.rubictron.hiblayer.dto.ItemDTO;

/**
 *
 * @author rubictron
 */
public interface ItemController {

    boolean add(ItemDTO t) throws Exception;

    boolean update(ItemDTO t) throws Exception;

    boolean delete(int id) throws Exception;

    ItemDTO getById(int id) throws Exception;

    ArrayList<ItemDTO> search(String id) throws Exception;

    ArrayList<ItemDTO> getAll() throws Exception;

}
