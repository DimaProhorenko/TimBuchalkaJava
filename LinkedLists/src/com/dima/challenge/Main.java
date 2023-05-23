package com.dima.challenge;

import java.util.LinkedList;
record Place(String name, int distance) {
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Place that = (Place) o;
        return name.equalsIgnoreCase(that.name());
    }

}
public class Main {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        addPlace(places, new Place("London", 1234));
        addPlace(places, new Place("London", 12345));
        addPlace(places, new Place("Odessa", 12));
        addPlace(places, new Place("New York", 666));
        System.out.println(places);
    }


    private static void addPlace(LinkedList<Place> list, Place place) {
        if(list.contains(place)) {
            System.out.println("Already in list");
            return;
        }
        list.add(getInsertionIndex(list, place), place);
    }

    private static int getInsertionIndex(LinkedList<Place> list, Place place) {
        int matchingIndex = 0;
        for(Place p:list) {
            if(place.distance() < p.distance()) {
                break;
            }
            matchingIndex++;
        }

        return matchingIndex;
    }
}
