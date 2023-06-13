package com.dima.challenge1;

public class Account {
    public enum Type {
        CHECKING,
        SAVINGS
    }

    private final Type type;
    private final double balance;

    public Account(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public Account(Type type) {
        this(type, 0);
    }

    public Account(double balance) {
        this(Type.CHECKING, balance);
    }

    public Account() {
        this(0);
    }

    public Type getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", balance=" + balance +
                '}';
    }
}
