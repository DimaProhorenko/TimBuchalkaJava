package com.dima;

public class Horse extends Mammal{
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.println(getInstanceType() + " -> makeNoise()");
    }

    @Override
    public void shedHair() {
        System.out.println(getInstanceType() + " sheds hair in spring");
    }
}
