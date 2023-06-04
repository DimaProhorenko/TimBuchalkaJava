package com.dima;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        String c = String.join("l", "Hel", "o");
        String d = "He".concat("llo");
        String e = "hello";

        List<String> hellos = new ArrayList<>(List.of(a, b, c, d, e));
//        hellos.forEach(s -> {
//            System.out.println(s + ": " + s.hashCode());
//        });

        Set<String> mySet = new HashSet<>(hellos);
//        System.out.println(mySet);

        Card cardA = new Card("King", "Clubs");
        Card cardB = new Card("Ace", "Spades");
        Card cardC = new Card("Jack", "Diamonds");

        Set<Card> cards = new HashSet<>(List.of(cardA, cardB, cardC));

        System.out.println(cards);
    }
}
