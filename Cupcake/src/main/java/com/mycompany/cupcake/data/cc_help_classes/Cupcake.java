
package com.mycompany.cupcake.data.cc_help_classes;

/**
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

    /**
     *
     * @return
     */
    public Bottom getBottom() {
        return bottom;
    }

    /**
     *
     * @return
     */
    public Topping getTopping() {
        return topping;
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
        return "Cupcake{" + "bottom=" + bottom + ", topping=" + topping + ", price=" + price + '}';
    }
    
    
    
    
}
