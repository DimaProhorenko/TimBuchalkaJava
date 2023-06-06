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

        printSeparator();
        System.out.printf("min: %s, first: %s\nmax: %s, last: %s\n",
                min.getName(), first.getName(), max.getName(), last.getName());
        printSeparator();
    }

    public static void printSeparator() {
        System.out.println("-".repeat(50));
    }
}
