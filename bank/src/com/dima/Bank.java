package com.dima;
import java.util.ArrayList;
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

    private Branch findBranch(String name) {
        int index = branches.indexOf(new Branch(name));
        if(index == -1) return null;
        return branches.get(index);
    }
}
