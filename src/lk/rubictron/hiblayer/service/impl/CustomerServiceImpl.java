/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.service.impl;

import java.util.ArrayList;
import lk.rubictron.hiblayer.core.Customer;
import lk.rubictron.hiblayer.repo.CustomerRepo;
import lk.rubictron.hiblayer.repo.impl.CustomerRepoImpl;
import lk.rubictron.hiblayer.service.CustomerService;

/**
 *
 * @author rubictron
 */
public class CustomerServiceImpl implements CustomerService{
    
    CustomerRepo repo;

    public CustomerServiceImpl() {
        
        this.repo=new CustomerRepoImpl();
    }
    

    @Override
    public boolean addCustomer(Customer t) throws Exception {

        return repo.add(t);
    
    }

    @Override
    public boolean updateCustomer(Customer t) throws Exception {
      return repo.update(t);
    }

    @Override
    public boolean deleteCustomer(int id) throws Exception {
        return repo.delete(id);
    }

    @Override
    public ArrayList<Customer> searchCustomer(String id) throws Exception {
       return repo.search(id);
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws Exception {
        
       return repo.getAll();
    }

    @Override
    public Customer getByIdCustomer(int id) throws Exception {
        return repo.getById(id);
    }
    
}
