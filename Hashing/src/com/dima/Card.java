package com.dima;

import java.util.Objects;

public class Card {
    private String face;
    private String suit;
    private int internalHashcode;

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
        internalHashcode = 1;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(face, card.face) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(face, suit);
    }
}
