package com.dima;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] names = {"Bob", "Anna", "Edna", "Ganvil", "Ethan", "Jake"};
        list.addAll(Arrays.asList(names));

        list.add("Mark");
        list.addAll(Arrays.asList("Gary", "Henry", "Grace"));
        list.removeIf(name -> name.charAt(0) == 'G');
        System.out.println(list.contains("Gary"));
        System.out.println(list);
    }
}
