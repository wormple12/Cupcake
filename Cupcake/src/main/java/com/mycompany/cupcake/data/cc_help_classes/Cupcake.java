
package com.mycompany.cupcake.data.cc_help_classes;

public class Cupcake {
    
    private Buttom bottom;
    private Topping topping;
    private double price;

    public Cupcake(Buttom bottom, Topping topping) {
        this.bottom = bottom;
        this.topping = topping;
        this.price = bottom.getPrice()+topping.getPrice();
    }

    public Buttom getBottom() {
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
