/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.core;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author rubictron
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double total;
    private Date date;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orders")
    private Set<OrderItem> orderItem=new HashSet<OrderItem>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the orderItem
     */
    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }

    /**
     * @param orderItem the orderItem to set
     */
    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
