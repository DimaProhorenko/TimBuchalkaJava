package com.dima;
import java.util.*;
public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Deck d = new Deck();
        Player p1 = new Player("Dima");

        Room room = new Room(d, p1, scanner);
        room.deal();
        room.printHand();
        room.drawCardLoop();
    }
}
