/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.logic;

import com.mycompany.cupcake.data.cc_help_classes.Cupcake;

/**
 *
 * @author Lukas Bjørnvad
 */
public class LineItem {
    private final Cupcake cupcake;
    private int qty;
    private final double price;
    
    public LineItem(Cupcake cupcake, int qty) {
        this.cupcake = cupcake;
        this.qty = qty;
        this.price = cupcake.getPrice()*qty;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public int getQty() {
        return qty;
    }

    public void addQty(int l) {
        this.qty = qty+l;
    }
    
    public double getPrice() {
        return price;
    }

}
