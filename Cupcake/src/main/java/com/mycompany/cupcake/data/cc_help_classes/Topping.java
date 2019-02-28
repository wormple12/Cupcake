/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.data.cc_help_classes;

/**
 *
 * @author Emil PC
 */
public class Topping {
    
    private int topping_id;
    private String topping_name;
    private double price;

    public Topping(int topping_id, String topping_name, double price) {
        this.topping_id = topping_id;
        this.topping_name = topping_name;
        this.price = price;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public String getTopping_name() {
        return topping_name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Topping{" + "topping_id=" + topping_id + ", topping_name=" + topping_name + ", price=" + price + '}';
    }    
    
}
