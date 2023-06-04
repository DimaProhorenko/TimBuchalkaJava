package deckOfCards;

public class Main {
    public static void main(String[] args) {
        Card jackOfClubs = new Card(Card.Suit.CLUB, "J");
        System.out.println(Card.getNumericCard(Card.Suit.HEART, 2));
        System.out.println(Card.getFaceCard(Card.Suit.DIAMOND, "Qq"));
    }
}
