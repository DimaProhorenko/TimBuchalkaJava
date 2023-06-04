package deckOfCards;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        System.out.println(deck);
    }
}
