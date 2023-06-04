package com.dima;
import java.util.*;

public class Room {
    private Deck deck;
    private Player p1;
    private Scanner scanner;

    public Room(Deck deck, Player p1, Scanner scanner) {
        this.deck = deck;
        this.p1 = p1;
        this.scanner = scanner;
    }

    public void deal() {
        p1.setHand(deck.initialDeal(2));
    }

    public void dealCard() {
        p1.addCardToHand(deck.drawCard());
        printHand();
    }

    public void printHand() {
        Deck.printDeck(p1.getHand(), "Your cards", 1);
        System.out.println("Total points: " + p1.getHandPoints());
    }

    public String getUserChoice() {
        System.out.println("Dray a card? (y/n)");
        return scanner.nextLine();
    }

    public void drawCardLoop() {
        String choice = "y";

        while(true) {
            choice = getUserChoice();
            if(!"YyNn".contains(choice)) {
                System.out.println("Invalid input");
            } else if("y".equalsIgnoreCase(choice)) {
                dealCard();
            } else {
                break;
            }
        }
    }

    public Player getP1() {
        return p1;
    }
}
