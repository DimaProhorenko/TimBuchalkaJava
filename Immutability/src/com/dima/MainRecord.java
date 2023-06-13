package com.dima;

public class MainRecord {
    public static void main(String[] args) {
        PersonRecord jane = new PersonRecord("Jane", "25.03.2000");
        PersonRecord mike = new PersonRecord("Mike", "19.12.2003");
        PersonRecord bill = new PersonRecord("Bill", "01.01.2007");
        PersonRecord bob = new PersonRecord("Bob", "12.04.1987");

        PersonRecord[] kids = bob.kids();

        kids[0] = jane;
        kids[1] = new PersonRecord("Ann", "01.01.1000");

        System.out.println(bob);
    }
}
