/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.rubictron.hiblayer.core;


import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author rubictron
 */
@Embeddable
public class OrderItemId implements Serializable{
    
    private int itemId;
    private int ordersId;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the ordersId
     */
    public int getOrdersId() {
        return ordersId;
    }

    /**
     * @param ordersId the ordersId to set
     */
    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }



 
    
}
