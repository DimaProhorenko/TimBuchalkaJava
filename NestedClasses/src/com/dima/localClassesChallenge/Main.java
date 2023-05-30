package com.dima.localClassesChallenge;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>(List.of(
           new Employee("Jack", "Racher", "23.04.2004"),
           new Employee("Martha", "Merker", "19.11.2017"),
           new Employee("Jeremy", "Black", "07.01.2022"),
           new Employee("Ethan", "Burke", "29.04.1999")
        ));

        printEmployees(emps, "years");
    }

    public static void printEmployees(List<? extends Employee> list, String sortField) {
        class SuperEmployee {
            private Employee emp;
            SuperEmployee(Employee emp) {
                this.emp = emp;
            }

            private String getFullName() {
                return emp.firstName() + " " + emp.lastName();
            }

            private int getYearsWorked() {
                int yearHired = Integer.parseInt(emp.hireDate().split("\\.")[2]);
                return LocalDate.now().getYear() - yearHired;
            }

            @Override
            public String toString() {
                return "%s has worked here for %d".formatted(getFullName(), getYearsWorked());
            }
        }

        List<SuperEmployee> superEmps = new ArrayList<>();
        for(Employee emp : list) {
            superEmps.add(new SuperEmployee(emp));
        }

        var comp = new Comparator<SuperEmployee>(){
            @Override
            public int compare(SuperEmployee o1, SuperEmployee o2) {
                if("name".equalsIgnoreCase(sortField)) {
                    return o1.getFullName().compareTo(o2.getFullName());
                }
                return o1.getYearsWorked() - o2.getYearsWorked();
            }
        };

        superEmps.sort(comp);
        for(SuperEmployee se : superEmps) {
            System.out.println(se);
        }
    }
}
