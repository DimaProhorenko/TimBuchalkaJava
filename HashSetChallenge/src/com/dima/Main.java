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

        Contact robin = emails.get(emails.indexOf(new Contact("Robin Hood")));
        robin.addEmail("Sherwood Forest");

        Contact mickey = emails.get(emails.indexOf(new Contact("Mickey Mouse")));
        mickey.addEmail("Dreamworks actor");

        mickey.replaceEmailIfExists("mmouse@dreamworksactor.com", "mcky@actor.org");

        printData("Emails", emailContacts);
        printData("Phones", phoneContacts);
    }


    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("----------------------------");
        System.out.println(header);
        System.out.println("----------------------------");
        contacts.forEach(System.out::println);
    }
}
