package com.dima;

import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean addCustomer(String name, double value) {
        Customer c = findCustomer(name);
        if(c != null) {
            return false;
        }
        customers.add(new Customer(name, value));
        return true;
    }

    public boolean addCustomerTransaction(String name, double value) {
        Customer c = findCustomer(name);
        if(c == null) return false;
        c.addTransaction(value);
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private Customer findCustomer(String name) {
        int index = customers.indexOf(new Customer(name, 0));
        if(index == -1) return null;
        return customers.get(index);
    }
}
