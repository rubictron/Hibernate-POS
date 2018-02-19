/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.core;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rubictron
 */
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String contact;
    private double salary;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Orders> ordersSet=new HashSet<Orders>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param sallary the salary to set
     */
    public void setSalary(double sallary) {
        this.salary = sallary;
    }

    /**
     * @return the ordersSet
     */
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    /**
     * @param ordersSet the ordersSet to set
     */
    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }



 
}
