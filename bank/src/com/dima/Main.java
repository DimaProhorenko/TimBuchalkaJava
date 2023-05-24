package com.dima;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank("PDP");

        b.addBranch("main");
        b.addCustomer("main", "Dima", 23.55);
        b.addCustomerTransaction("main", "Dima", 105);

        b.listCustomers("main", false);
    }
}
