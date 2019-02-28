/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.logic;

import java.util.List;

/**
 *
 * @author Lukas Bjørnvad
 */
public class ShoppingCart {
    List<LineItem> items;
    public void addToCart(LineItem x){
        items.add(x);
    }
    public List<LineItem> getCart(){
        return items;
    }
    
}
