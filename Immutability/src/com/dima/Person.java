package com.dima;

import java.util.Arrays;

public class Person {
    private String name;
    private String dob;
    private Person[] kids;

    public Person(String name, String dob, Person... kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        String kidsString = "n/a";
        if (kids != null) {
            String[] kidsNames = new String[kids.length];
            Arrays.setAll(kidsNames, i -> kidsNames[i] = kids[i] == null ? "" : kids[i].name);
            kidsString = String.join(", ", kidsNames);
        }
        return "Name -> %s, Date of birth -> %s, Kids -> %s".formatted(name, dob, kidsString);
    }
}
