package com.dima;
import java.util.List;
import java.util.ArrayList;

public class Store {
    private List<Product> products;
    private List<OrderItem> orders;

    public Store() {
        products = new ArrayList<>(List.of(new Coke(), new Bread()));
        orders = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addOrder(String )

    public static void main(String[] args) {
        Store store = new Store();
        store.getProducts().get(0).printItemLine(10);
    }


    public List<Product> getProducts() {
        return products;
    }
}
