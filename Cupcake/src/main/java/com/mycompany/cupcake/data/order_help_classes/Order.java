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
public class Order {

    private final int orderNumber;
    private final String username;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.username = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getUsername() {
        return username;
    }

}
