/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller;

import java.util.ArrayList;
import lk.rubictron.hiblayer.dto.CustomerDTO;

/**
 *
 * @author rubictron
 */
public interface CustomerController {

    boolean add(CustomerDTO t) throws Exception;

    boolean update(CustomerDTO t) throws Exception;

    boolean delete(int id) throws Exception;

    CustomerDTO getById(int id) throws Exception;
    
    ArrayList<CustomerDTO> search(String id) throws Exception;

    ArrayList<CustomerDTO> getAll() throws Exception;
}
