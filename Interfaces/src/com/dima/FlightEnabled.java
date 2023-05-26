package com.dima;

public interface FlightEnabled {
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;
    void takeOff();

    void land();

    void fly();

    default String transition() {
        return "Transition is not implemented on " + getClass().getName();
    }
}
