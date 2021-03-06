/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.data.cc_help_classes;

/**
 *Helper class for the bottom of a cupcake.
 *Holds relevance for functions where the SQL "bottoms" table is used and when constucting a Cupcake object.
 * @author Emil PC
 */
public class Bottom {
    
    private int bottom_id;
    private String bottom_name;
    private double price;

    /**
     *
     * @param bottom_id
     * @param bottom_name
     * @param price
     */
    public Bottom(int bottom_id, String bottom_name, double price) {
        this.bottom_id = bottom_id;
        this.bottom_name = bottom_name;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getBottom_id() {
        return bottom_id;
    }

    /**
     *
     * @return
     */
    public String getBottom_Name() {
        return bottom_name;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cupcake_bottom{" + "name=" + bottom_name + ", price=" + price + '}';
    }
    
    
    
}
