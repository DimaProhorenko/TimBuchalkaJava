package com.dima;

import java.util.Arrays;

public record PersonRecord(String name, String dob, PersonRecord... kids) {

    public PersonRecord(String name, String dob) {
        this(name, dob, new PersonRecord[10]);
    }

    public PersonRecord[] kids() {
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
