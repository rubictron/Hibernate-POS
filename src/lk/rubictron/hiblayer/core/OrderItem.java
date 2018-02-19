/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.core;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author rubictron
 */
@Entity
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemId orderItemId = new OrderItemId();

    private int quantity;

    @MapsId("itemId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    @MapsId("ordersId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Orders orders;

    /**
     * @return the orderItemId
     */
    public OrderItemId getOrderItemId() {
        return orderItemId;
    }

    /**
     * @param orderItemId the orderItemId to set
     */
    public void setOrderItemId(OrderItemId orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the orders
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

}
