
package com.mycompany.cupcake.data.cc_help_classes;

/**
 *Help class for the entire Cupcake.
 *Implements both the "Bottom" and the "Topping" objects.
 *
 * @author Henning
 */
public class Cupcake {
    
    private Bottom bottom;
    private Topping topping;
    private double price;

    /**
     *
     * @param bottom
     * @param topping
     */
    public Cupcake(Bottom bottom, Topping topping) {
        this.bottom = bottom;
        this.topping = topping;
        this.price = bottom.getPrice()+topping.getPrice();
    }

 
    public Bottom getBottom() {
        return bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Cupcake{" + "bottom=" + bottom + ", topping=" + topping + ", price=" + price + '}';
    }   
}
