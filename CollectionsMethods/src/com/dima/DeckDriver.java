package com.dima;
import java.util.*;

public class DeckDriver {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Card> hand = deck.initialDeal(2);
        System.out.println(deck);
        System.out.println(hand);
    }
}
