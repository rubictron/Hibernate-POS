/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.repo;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Customer;

/**
 *
 * @author rubictron
 */
public interface CustomerRepo {
    
     boolean add(Customer t) throws Exception;

    boolean update(Customer t) throws Exception;

    boolean delete(int id) throws Exception;

    Customer getById(int id) throws Exception;

    ArrayList<Customer> search(String id) throws Exception;

    ArrayList<Customer> getAll() throws Exception;

    
}
