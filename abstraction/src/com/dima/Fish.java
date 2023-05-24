package com.dima;

public class Fish extends Animal{

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")) {
            System.out.println("Fish swims slowly");
        } else {
            System.out.println("Fish swims fast");
        }
    }

    @Override
    public void makeNoise() {
        System.out.println("Fish -> makeNoise()");
    }
}
