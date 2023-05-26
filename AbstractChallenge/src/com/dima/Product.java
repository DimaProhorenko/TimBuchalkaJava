package com.dima;
import java.text.DecimalFormat;
public abstract class Product {
    protected String type;
    protected double price;
    protected String description;
    private DecimalFormat df = new DecimalFormat("0.00");

    public Product(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public void printItemLine(int quantity) {
        System.out.println(type + " x " + quantity + " -> " + df.format(getSalesPrice(quantity)));
    }

    public abstract void showDetails();
}