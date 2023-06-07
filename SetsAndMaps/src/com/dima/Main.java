package com.dima;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        Comparator<Contact> comparator = Comparator.comparing(Contact::getName).reversed();
        NavigableSet<Contact> sorted = new TreeSet<>(comparator);
        sorted.addAll(phones);
//        sorted.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
//        fullList.forEach(System.out::println);

        Contact min = Collections.min(sorted, sorted.comparator());
        Contact max = Collections.max(sorted, sorted.comparator());

        Contact first = sorted.first();
        Contact last = sorted.last();

//        printSeparator();
//        System.out.printf("min: %s, first: %s\nmax: %s, last: %s\n",
//                min.getName(), first.getName(), max.getName(), last.getName());
//        printSeparator();
//        NavigableSet<Contact> copy = new TreeSet<>(sorted);
//        Contact a = copy.pollFirst();
//        printSeparator();
//        System.out.println(sorted);
//        printSeparator();
//        System.out.println(copy);
//        printSeparator();

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");
    }

    public static void printSeparator() {
        System.out.println("-".repeat(50));
    }
}
