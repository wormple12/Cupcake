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
public class Bottom {
    
    private String name;
    private int price;

    public Bottom(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cupcake_bottom{" + "name=" + name + ", price=" + price + '}';
    }
    
    
    
}
