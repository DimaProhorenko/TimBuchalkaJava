package com.dima.challenge1;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account(100.95);
        Account acc2 = new Account(Account.Type.SAVINGS, 756.74);
        Account acc3 = new Account(Account.Type.SAVINGS, 1.85);
        Account[] a = {acc1, acc2};
        a[0] = acc3;
        Customer c = new Customer("Tom", a);

        System.out.println(c);
    }
}
