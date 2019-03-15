/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.data.cc_help_classes;

import com.mycompany.cupcake.data.cc_help_classes.Cupcake;

/**
 *
 * @author Lukas Bjørnvad
 */

public class LineItem {
    private final Cupcake cupcake;
    private int qty;
    private final double price;
    /**
     * Gets a Cupcake and quantity parameters, the price is calculated based on the inherent price of the cupcake object
     * @param cupcake
     * @param qty 
     */
    public LineItem(Cupcake cupcake, int qty) {
        this.cupcake = cupcake;
        this.qty = qty;
        this.price = cupcake.getPrice()*qty;
    }

    /**
     *
     * @return cupcake
     */
    public Cupcake getCupcake() {
        return cupcake;
    }

    /**
     *
     * @return quantity
     */
    public int getQty() {
        return qty;
    }
/**
 * Adds more to quantity
 * @param aqty
 */
    public void addQty(int aqty) {
        this.qty = qty+aqty;
    }
    
    /**
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

}
