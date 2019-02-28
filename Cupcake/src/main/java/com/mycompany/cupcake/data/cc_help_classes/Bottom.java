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
    
    private int bottom_id;
    private String bottom_name;
    private double price;

    public Bottom(int bottom_id, String bottom_name, double price) {
        this.bottom_id = bottom_id;
        this.bottom_name = bottom_name;
        this.price = price;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public String getBottom_Name() {
        return bottom_name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cupcake_bottom{" + "name=" + bottom_name + ", price=" + price + '}';
    }
    
    
    
}
