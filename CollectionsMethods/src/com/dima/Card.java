package com.dima;

import java.util.*;

public record Card(Suit suit, String face, int rank) {
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            return (new char[] {9827, 9830, 9829, 9824}[this.ordinal()]);
        }
    }

    @Override
    public String toString() {
        return "%s%s(%d)".formatted(face, suit.getImage(), rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber) {
        if(cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid card number");
        return null;
    }

    public static Card getFaceCard(Suit suit, char face) {
        int charIndex = "JQKA".indexOf(String.valueOf(face).toUpperCase());
        if(charIndex > -1) {
            return new Card(suit, "" + face, charIndex + 9);
        }
        System.out.println("Invalid card face");
        return null;
    }

    public static List<Card> getStandartDeck() {
        List<Card> deck = new ArrayList<>(52);

        for (Suit suit : Suit.values()) {
            for (int i = 2; i < 11; i++) {
                deck.add(getNumericCard(suit, i));
            }

            for (char c : new char[] {'J', 'Q', 'K', 'A'}) {
                deck.add(getFaceCard(suit, c));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("------------------------------------");
        if(description != null) {
            System.out.println(description);
        }
        int cardsPerRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsPerRow;
            int endIndex = startIndex + cardsPerRow;
            deck.subList(startIndex, endIndex).forEach(card -> System.out.print(card + " "));
            System.out.println();
        }
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, null, 4);
    }
}
