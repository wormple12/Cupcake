/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.logic;

import com.mycompany.cupcake.data.cc_help_classes.Cupcake;
import java.util.List;

/**
 *
 * @author Lukas Bjørnvad
 */
public class ShoppingCart {

    List<LineItem> items;


    public void addToCart(LineItem x) {
        int check = checkIf(x.getCupcake());
        if (check >= 0) {
            items.get(check).addQty(check);
        } else {
            items.add(x);

        }
    }

    public List<LineItem> getCart() {
        return items;
    }

    public double getTPrice() {
        double price = 0;
        for (int i = 0; i < items.size(); i++) {
            price = price + items.get(i).getPrice();
        }
        return price;
    }

    private int checkIf(Cupcake cupcake) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getCupcake().equals(cupcake)) {
                return i;
            }
        }
        return -1;
    }
}
