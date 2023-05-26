package com.dima;

public class Coke extends Product{


    public Coke() {
        super("Soda", 3.99, "Best soda in the USA");
    }

    @Override
    public void showDetails() {
        System.out.println(type + " " + price + "$ " + description);
    }
}
