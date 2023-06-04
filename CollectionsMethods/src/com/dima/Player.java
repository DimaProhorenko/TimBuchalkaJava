package com.dima;
import java.util.*;
public class Player {
    private String name;
    private List<Card> hand;
    private int handPoints;

    public Player(String name) {
        this(name, new ArrayList<>());
    }

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.handPoints = calcHandPoints();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
        handPoints += card.rank();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandPoints() {
        return handPoints;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
        handPoints = calcHandPoints();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", handPoints=" + handPoints +
                '}';
    }

    private int calcHandPoints() {
        return hand.stream().mapToInt(el -> el.rank()).sum();
    }
}
