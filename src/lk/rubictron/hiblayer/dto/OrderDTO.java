/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.dto;

import java.sql.Date;

/**
 *
 * @author rubictron
 */
public class OrderDTO {
    
     
    private int orderId;
    private String date;
    private int customerId;
    private double totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, String  date, int customerId, double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }
    public OrderDTO( String date, int customerId, double totalPrice) {
        this.date = date;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

 

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    
    
}
