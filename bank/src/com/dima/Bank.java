package com.dima;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String name) {
        if(findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            return false;
        }
        branch.addCustomer(customerName, initialTransaction);
        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionValue) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            return false;
        }
        branch.addCustomerTransaction(customerName, transactionValue);
        return true;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            return false;
        }
        System.out.println("Customer details for branch Adelaide");
        List<Customer> customers = branch.getCustomers();
        for(int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println("Customer: " + c.getName() + "[" + (i + 1) + "]");
            if(printTransactions) {
                System.out.println("Transactions");
                for(int j = 0; j < c.getTransactions().size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount " + c.getTransactions().get(j));
                }
            }
        }
        return true;
    }

    private Branch findBranch(String name) {
        int index = branches.indexOf(new Branch(name));
        if(index == -1) return null;
        return branches.get(index);
    }
}
