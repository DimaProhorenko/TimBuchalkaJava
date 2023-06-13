package com.dima;

public class Main {
    public static void main(String[] args) {
        Person jane = new Person("Jane", "25.03.2000");
        Person mike = new Person("Mike", "19.12.2003");
        Person bill = new Person("Bill", "01.01.2007");
        Person bob = new Person("Bob", "12.04.1987", jane, mike, bill);

        bob.setKids(new Person[] {jane});

        Person[] kids = bob.getKids();
        kids[0] = mike;

        bob.setKids(null);
        System.out.println(bob);
    }
}
