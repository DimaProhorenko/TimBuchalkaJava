package com.dima;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] names = {"Bob", "Anna", "Edna", "Ethan", "Jake"};
        list.addAll(Arrays.asList(names));

        System.out.println(list);
    }
}
