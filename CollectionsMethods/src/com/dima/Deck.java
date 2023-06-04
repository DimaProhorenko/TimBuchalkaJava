package com.dima;
import java.util.*;

public class Deck {
    private List<Card> deck;
    private static Random random = new Random();

    public Deck() {
        deck = Card.getStandartDeck();
    }

    public Card drawCard() {
        return deck.remove(random.nextInt(0, deck.size()));
    }

    public List<Card> initialDeal(int numOfCards) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numOfCards; i++) {
            hand.add(deck.remove(random.nextInt(0, deck.size())));
        }
        return hand;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
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
