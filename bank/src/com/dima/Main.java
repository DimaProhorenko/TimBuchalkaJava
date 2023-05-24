package com.dima;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank("PDP");

        b.addBranch("main");

        System.out.println(b.getBranches());
    }
}
