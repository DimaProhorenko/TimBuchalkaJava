package com.dima.module;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>(List.of(
           new Employee(1001, "Tim", 2018),
           new Employee(1003, "Jared", 2005),
           new Employee(3450, "Dean", 2005),
           new Employee(4373, "John", 2023),
           new Employee(2341, "Ralph", 2019)
        ));
//        emps.sort(new EmployeeComparator<>());
//        Collections.sort(emps, Comparator.comparingInt(Employee::getYearStarted));
        emps.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
//        printEmps(emps);

        List<StoreEmployee> storeEmps = new ArrayList<>(List.of(
            new StoreEmployee(1010, "Ron", 2019, "ATB"),
            new StoreEmployee(1000, "Harry", 2009, "ATB"),
            new StoreEmployee(8484, "Jack", 2023, "Silpo"),
            new StoreEmployee(9384, "Nastya", 2023, "Kopiyka"),
            new StoreEmployee(9824, "Dima", 2022, "Comfy")
        ));
        storeEmps.sort(new StoreEmployee().new StoreComparator<>());
        printEmps(storeEmps);
    }

    public static <T extends Employee> void printEmps(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
}
