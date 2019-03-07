/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.data.order_help_classes;

/**
 *
 * @author Henning
 */
public class OrderedCupcakes {
    
    int orderNumber;
    int topId;
    int botId;
    int qty;

    public OrderedCupcakes(int orderNumber, int topId, int botId, int qty) {
        this.orderNumber = orderNumber;
        this.topId = topId;
        this.botId = botId;
        this.qty = qty;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTopId() {
        return topId;
    }

    public int getBotId() {
        return botId;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "OrderedCupcakes{" + "orderNumber=" + orderNumber + ", topId=" + topId + ", botId=" + botId + ", qty=" + qty + '}';
    }
    
    
    
}
