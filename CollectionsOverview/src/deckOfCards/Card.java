package deckOfCards;

import java.util.*;

public class Card {
    private static final String faces = "JQKA";
    public enum Suit {
        CLUB(9827),
        DIAMOND(9830),
        SPADE(9824),
        HEART(9829);

        public int asciiValue;

        Suit(int asciiValue) {
            this.asciiValue = asciiValue;
        }

        public char asciiValue() {
            return (char) asciiValue;
        }
    };

    private enum Rank{
        NUM_2(0),
        NUM_3(1),
        NUM_4(2),
        NUM_5(3),
        NUM_6(4),
        NUM_7(5),
        NUM_8(6),
        NUM_9(7),
        NUM_10(8),
        J(9),
        Q(10),
        K(11),
        A(12),
        DEFAULT(-1);

        private int rankNum;

        Rank(int rankNum) {
            this.rankNum = rankNum;
        }

        public int getRankNum() {
            return rankNum;
        }
    }

    private Suit suit;
    private String face;
    private int rank;

//    public Card(Suit suit, String face) {
//        this(suit, face, 0);
//    }

    public Card(Suit suit, String face) {
        this.suit = suit;
        this.face = face;
        this.rank = calcRank(face);
    }
    public Card(Suit suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "%s%s(%d)".formatted(face, (char) suit.asciiValue(), rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumVal) {
        int cardRank = calcRank(String.valueOf(cardNumVal));
        if (cardRank >= 0) {
            return new Card(suit, String.valueOf(cardNumVal), cardRank);
        }
        return null;
    }

    public static Card getFaceCard(Suit suit, String face) {
        int cardRank = calcRank(face);
        if(cardRank >= 0) {
            return new Card(suit, face, cardRank);
        }
        return null;
    }

    public static List<Card> getStandardDeck() {
        return new ArrayList<Card>();
    }


    private static int calcRank(String face) {
        if(faces.contains(face)) {
            return Rank.valueOf(face).getRankNum();
        }
        try {
            int faceNum = Integer.parseInt(face);
            if(faceNum >= 2 && faceNum <= 10) {
                return Rank.valueOf("NUM_" + face).getRankNum();
            } else if(faces.contains(face)) {
                return Rank.valueOf(face).getRankNum();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input mismatch\n" + e.getMessage());
        }
        return Rank.DEFAULT.getRankNum();
    }
}
