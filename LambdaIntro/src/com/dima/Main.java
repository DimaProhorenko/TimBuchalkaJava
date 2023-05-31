package com.dima;

import java.util.*;

public class Main {
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Jerry", "Black"),
                new Person("Max", "WaterMelk"),
                new Person("Ethan", "Burke"),
                new Person("Sally", "Brown"),
                new Person("Mike", "Wazowskie"),
                new Person("Andrew", "Black"),
                new Person("Trevis", "Burke")
        ));

//        Anonymous class
        Comparator<Person> comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        interface EnhancedComparator<T> extends Comparator<T> {
            public int secondLevel(T t1, T t2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return result == 0 ? secondLevel(o1, o2) : result;
            }

            @Override
            public int secondLevel(Person t1, Person t2) {
                return t1.firstName.compareTo(t2.firstName);
            }
        };

//        people.sort(comparatorLastName);
//        people.sort((p1, p2) -> p1.firstName.compareTo(p2.lastName));
        people.sort(comparatorMixed);
        printPeople(people);
    }

    public static void printPeople(List<? extends Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }
}
