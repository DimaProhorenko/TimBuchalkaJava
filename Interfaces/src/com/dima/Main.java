package com.dima;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        Trackable trackable = bird;
        FlightEnabled fe = bird;

        FlightEnabled donald = new Duck();

//        bird.move();
//        bird.takeOff();
//        fe.fly();
//        trackable.track();
//        fe.land();

//        inFlight(bird);
//        System.out.println("------------------------------------------");
//        inFlight(donald);
        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.println(String.format("The %s travelled %.2f kms or %.2f miles.", bird.getClass().getSimpleName(), kmsTraveled, milesTraveled));
    }

    public static void inFlight(FlightEnabled fe) {
        fe.takeOff();
        fe.fly();
        if(fe instanceof Trackable trackable) {
            trackable.track();
        }

        fe.land();
    }
}
