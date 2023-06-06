package com.dima;
import java.util.*;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();


    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }
    public Contact(String name, String email, long phone) {
        this.name = name;
        if(email != null) {
            emails.add(email);
        }

        if(phone > 0) {
            phones.add(formatPhone(String.valueOf(phone)));
        }
    }


    public String getName() {
        return name;
    }

    public Contact mergeContactDate(Contact c) {
        Contact result = new Contact(this.name);
        result.emails = new HashSet<>(this.emails);
        result.phones = new HashSet<>(this.phones);
        result.emails.addAll(c.emails);
        result.phones.addAll(c.phones);
        return result;
    }

    public boolean addEmail(String companyName) {
        String newEmail = "%c%s@%s.com".formatted(name.toLowerCase().charAt(0),
                name.toLowerCase().split(" ")[1],
                companyName.replaceAll(" ", "").toLowerCase());
        if(!emails.contains(newEmail)) {
            emails.add(newEmail);
            return true;
        }
        System.out.println("Email already exists");
        return false;
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {
        if(emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }

    @Override
    public String toString() {
        return "%s\nEmails: %s\nPhones: %s\n".formatted(name, emails, phones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName());
    }

    @Override
    public int hashCode() {
        return 33 * Objects.hash(getName());
    }

    private String formatPhone(String phone) {
        return "(%s)-%s-%s".formatted(phone.substring(0,3), phone.substring(3, 6), phone.substring(6, 10));
    }
}
