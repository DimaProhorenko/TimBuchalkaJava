package com.dima;

public class Dog extends Mammal{

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")) {
            System.out.println("dog slow");
        } else {
            System.out.println("Freaking fast dog");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getInstanceType() + " sheds all the time");
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof");
    }
}
