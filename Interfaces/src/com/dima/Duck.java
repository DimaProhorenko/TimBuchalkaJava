package com.dima;

public class Duck extends Animal implements FlightEnabled{
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " takes off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }
}
