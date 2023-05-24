package com.dima;

public abstract class Mammal extends Animal{

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print(getInstanceType() + " ");
        System.out.print("slow".equalsIgnoreCase(speed) ? "walks" : "runs\n");
    }

    public abstract void shedHair();
}
