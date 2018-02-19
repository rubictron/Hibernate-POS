/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.service;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Customer;

/**
 *
 * @author rubictron
 */
public interface CustomerService {
    
     boolean addCustomer(Customer t) throws Exception;

    boolean updateCustomer(Customer t) throws Exception;

    boolean deleteCustomer(int id) throws Exception;

    Customer getByIdCustomer(int id) throws Exception;

    ArrayList<Customer> searchCustomer(String id) throws Exception;

    ArrayList<Customer> getAllCustomer() throws Exception;
    
}
