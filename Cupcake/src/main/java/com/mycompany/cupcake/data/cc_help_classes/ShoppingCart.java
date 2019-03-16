/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.data.cc_help_classes;

import com.mycompany.cupcake.data.cc_help_classes.LineItem;
import com.mycompany.cupcake.logic.DataException;
import com.mycompany.cupcake.data.cc_help_classes.Cupcake;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Bjørnvad
 */
public class ShoppingCart {

    ArrayList<LineItem> items = new ArrayList<>();

    /**
     * Adds an LineItem to the items ArrayList, if the cupcake type already is
     * in the shoppingcart, then it adds to the quantity instead of making a new
     * LineItem
     *
     * @param item
     * @throws DataException
     */
    public void addToCart(LineItem item) throws DataException {
        int check = checkIf(item.getCupcake());
        if (check >= 0) {
            items.get(check).addQty(item.getQty());
        } else {
            items.add(item);

        }
    }

    /**
     *
     * @return ArrayList items
     */
    public ArrayList<LineItem> getCart() {
        return items;
    }

    /**
     *
     * @return returns total price
     */
    public double getTPrice() {
        double price = 0;
        for (int i = 0; i < items.size(); i++) {
            price = price + items.get(i).getPrice();
        }
        return price;
    }

    /**
     * checks if there is already such an cupcake in the ArrayList
     *
     * @param cupcake
     * @return
     */
    private int checkIf(Cupcake cupcake) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getCupcake().equals(cupcake)) {
                return i;
            }
        }
        return -1;
    }
}
