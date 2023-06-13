package com.dima.challenge1;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Customer {

    private static int lastId = 43509;
    private final String name;
    private final int id;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(String name, Account... accounts) {
        this.name = name;
        this.id = lastId++;
        this.accounts.addAll(List.of(Arrays.copyOf(accounts, accounts.length)));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", accounts=" + accounts +
                '}';
    }
}
