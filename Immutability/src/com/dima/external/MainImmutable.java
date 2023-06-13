package com.dima.external;

import com.dima.PersonImmutable;

public class MainImmutable {
    public static void main(String[] args) {
        PersonImmutable jane = new PersonImmutable("Jane", "25.03.2000");
        PersonImmutable mike = new PersonImmutable("Mike", "19.12.2003");
        PersonImmutable bill = new PersonImmutable("Bill", "01.01.2007");
        PersonImmutable ann = new PersonImmutable("Ann", "01.01.2007");
        PersonImmutable bob = new PersonImmutable("Bob", "12.04.1987", jane, mike, bill);

        PersonImmutable[] kids = bob.getKids();

        kids[0] = ann;

        System.out.println(bob);
    }
}
