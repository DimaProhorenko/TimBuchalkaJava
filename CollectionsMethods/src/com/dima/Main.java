package com.dima;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandartDeck();
//        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHeart);
//        Card.printDeck(Arrays.asList(cardArray));

        List<Card> acesOfHearts = Collections.nCopies(22, aceOfHeart);

        Card.printDeck(acesOfHearts, "Aces of hearts", 6);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');

        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);


//        List<Card> deck2 = new ArrayList<>();
//        Collections.addAll(deck2, Card.getFaceCard(Card.Suit.DIAMOND, 'J'), kingOfClubs);
//        Card.printDeck(deck2, null, 1);

        Collections.shuffle(deck);
        Card.printDeck(deck);

        Collections.reverse(deck);
        Card.printDeck(deck);

        Comparator<Card> sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);

        Collections.sort(deck, sortingAlgorithm);

        Card.printDeck(deck, null, 13);
    }
}
