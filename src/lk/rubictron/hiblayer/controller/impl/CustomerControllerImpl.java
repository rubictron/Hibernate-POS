/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.controller.impl;

import java.util.ArrayList;
import lk.rubictron.hiblayer.controller.CustomerController;
import lk.rubictron.hiblayer.core.Customer;
import lk.rubictron.hiblayer.dto.CustomerDTO;
import lk.rubictron.hiblayer.service.CustomerService;
import lk.rubictron.hiblayer.service.impl.CustomerServiceImpl;

/**
 *
 * @author rubictron
 */
public class CustomerControllerImpl implements CustomerController {

    CustomerService service;

    public CustomerControllerImpl() {
        this.service = new CustomerServiceImpl();
    }

    @Override
    public boolean add(CustomerDTO t) throws Exception {

        Customer customer = new Customer();
        customer.setName(t.getName());
        customer.setContact(t.getContact());
        customer.setSalary(t.getSalary());

        return service.addCustomer(customer);

    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {

        Customer customer = new Customer();
        customer.setId(t.getId());
        customer.setName(t.getName());
        customer.setContact(t.getContact());
        customer.setSalary(t.getSalary());

        return service.updateCustomer(customer);

    }

    @Override
    public boolean delete(int id) throws Exception {
        
        return service.deleteCustomer(id);
    }

    @Override
    public ArrayList<CustomerDTO> search(String id) throws Exception {

        ArrayList<Customer> customers = service.searchCustomer(id);
        ArrayList<CustomerDTO> cusomersDTO = new ArrayList<>();

        for (Customer customer : customers) {

            cusomersDTO.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary()));

        }

        return cusomersDTO;

    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        
        ArrayList<Customer> customers = service.getAllCustomer();
        ArrayList<CustomerDTO> cusomersDTOs=new ArrayList<>();
        
        for (Customer customer : customers) {

            CustomerDTO DTO= new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary());
            
            cusomersDTOs.add(DTO);
            

        }

        return cusomersDTOs;
    }

    @Override
    public CustomerDTO getById(int id) throws Exception {
       Customer customer = service.getByIdCustomer(id);
        CustomerDTO dto=new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary());

        

        return dto;
    }

}
