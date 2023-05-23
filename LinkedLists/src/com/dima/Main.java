package com.dima;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();
        places.add("Sydney");
        places.add(0, "London");
//        System.out.println(places);
        addMoreElements(places);
        System.out.println(places);
//        removeElements(places);
//        System.out.println(places);
//        gettingElements(places);
//        printItinerary(places);
        testIterator(places);
    }


    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Ohio");
        list.addLast("New York");

        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Darwin");

//        Stack methods
        list.push("Springfield");
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println(list.get(4));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("Darwin is at index: " + list.indexOf("Darwin"));
    }

    private static void printItinerary(List<String> list) {
        String prevTown = list.get(0);
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()) {
            String town = iterator.next();
            System.out.println(String.format("--> From %s to %s", prevTown, town));
            prevTown = town;
        }
    }

    private static void testIterator(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
            if(iterator.next().equalsIgnoreCase("Brisbane")) {
//                iterator.remove();
                iterator.add("Kyiv");
            }
        }

        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println(list);
    }
}
