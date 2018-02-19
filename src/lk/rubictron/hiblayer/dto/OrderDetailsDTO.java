/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.dto;

/**
 *
 * @author rubictron
 */
public class OrderDetailsDTO {

   private int orderId;
   private int itemId;
    private int quantity;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(int orderId, int itemId, int quentity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quentity;
    }
    public OrderDetailsDTO( int itemId, int quentity) {
        this.itemId = itemId;
        this.quantity = quentity;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quentity the quantity set
     */
    public void setQuantity(int quentity) {
        this.quantity = quentity;
    }

    

    
    

}
