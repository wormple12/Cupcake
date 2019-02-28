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
public class Buttom {
    
    private int buttom_id;
    private String buttom_name;
    private double price;

    public Buttom(int buttom_id, String buttom_name, double price) {
        this.buttom_id = buttom_id;
        this.buttom_name = buttom_name;
        this.price = price;
    }

    public int getButtom_id() {
        return buttom_id;
    }

    public String getButtom_Name() {
        return buttom_name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cupcake_buttom{" + "name=" + buttom_name + ", price=" + price + '}';
    }
    
    
    
}
