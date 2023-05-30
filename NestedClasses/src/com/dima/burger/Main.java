package com.dima.burger;

public class Main {
    public static void main(String[] args) {
        Meal myMeal = new Meal();
//        System.out.println(myMeal);
        Meal USMeal = new Meal();
        USMeal.addTopping("cheese", "Mayo", "Chedder");
        System.out.println(USMeal);
    }
}
