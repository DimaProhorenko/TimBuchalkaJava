package com.dima.burger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private double conversionRate;
    private Burger burger;
    private Item drink;
    private Item side;


    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger();
        drink = new Item("Coke", "drink", 2.99);
        side = new Item("Fries", "side", 3.99);
    }

    public double getTotal() {
        double total = burger.getTotalBurgerPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    public void addTopping(String... args) {
        burger.addTopping(args);
    }

    @Override
    public String toString() {
        return "%s\n%s\n%s\nTotal: %.2f$".formatted(burger, drink, side, getTotal());
    }

    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, "burger".equalsIgnoreCase(type) ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%s %5s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item {

        private enum Extra {
            AVOCADO(1.99),
            BACON(2.35),
            CHEESE(2.55),
            MAYO(0),
            MUSTARD(0);

            private double price;

            Extra(double price) {
                this.price = price;
            }

            public double getPrice() {
                return price;
            }
        }
        private List<Item> toppings;

        public Burger() {
            this("Classic", 4.99, new ArrayList<>());
        }

        public Burger(String name, double price, List<Item> toppings) {
            super(name, "Burger", price);
            this.toppings = toppings;
        }

        public void addTopping(String... args) {
            for(String topping : args) {
                try {
                    Extra extra = Extra.valueOf(topping.toUpperCase());
                    toppings.add(new Item(extra.name(), "TOPPING", extra.getPrice()));
                } catch(IllegalArgumentException ie) {
                    System.out.println("%s -> don't have this topping".formatted(topping));
                }
            }
        }

        public double getTotalBurgerPrice() {
            double totalTopingPrice = toppings.stream().mapToDouble(el -> el.price).sum();
            return super.price + totalTopingPrice;
        }

        public double getPrice() {
            return super.price;
        }

        @Override
        public String toString() {
            return super.toString() + " %s,\nTotal burger price: $%.2f".formatted(toppings, getTotalBurgerPrice());
        }

    }
}
