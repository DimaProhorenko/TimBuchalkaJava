package com.dima;

import java.util.Arrays;

public class PersonImmutable {
    private final String name;
    private final String dob;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable... kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public PersonImmutable[] getKids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
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
