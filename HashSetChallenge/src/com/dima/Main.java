package com.dima;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Contact c = new Contact("Dima", "dima@gmail.com", 1234567890L);
//        Contact a = new Contact("Jack", "tech@help.com", 6663331234L);
        List<Contact> emails = new ArrayList<>(ContactData.getData("email"));
        List<Contact> phones = new ArrayList<>(ContactData.getData("phone"));
//        printData("Emails", emails);
//        printData("Phones", phones);
        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

//        Contact robin = emails.get(emails.indexOf(new Contact("Robin Hood")));
//        robin.addEmail("Sherwood Forest");
//
//        Contact mickey = emails.get(emails.indexOf(new Contact("Mickey Mouse")));
//        mickey.addEmail("Dreamworks actor");
//
//        mickey.replaceEmailIfExists("mmouse@dreamworksactor.com", "mcky@actor.org");

//        printData("Emails", emailContacts);
//        printData("Phones", phoneContacts);

//        Union of two sets
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emails);
        unionAB.addAll(phones);

        printData("(A \u222A B) Union of elements", unionAB);

//        Intersection of two sets
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);

        printData("(A \u2229 B) Intersection of elements", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);

        printData("(B \u2229 A) Intersection of B A", intersectBA);

//        Difference

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);

        printData("(A - B) Difference", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);

        printData("(B - A) Difference", BMinusA);

//        Symmetric Difference
        Set<Contact> symmetricDifference = new HashSet<>(AMinusB);
        symmetricDifference.addAll(BMinusA);

        printData("Symmetric Difference", symmetricDifference);
    }


    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("----------------------------");
        System.out.println(header);
        System.out.println("----------------------------");
        contacts.forEach(System.out::println);
    }
}
