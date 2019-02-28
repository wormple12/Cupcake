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
    private Cupcake cupcake;
    private int qty;
    private double price;
    public LineItem(Cupcake cupcake, int qty) {
        this.cupcake = cupcake;
        this.qty = qty;
        this.price = cupcake.getPrice();
    }
   
    
}
