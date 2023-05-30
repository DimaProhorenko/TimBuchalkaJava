package com.dima.module;
import java.util.Comparator;
public class Employee {

    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
        private String compareType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String compareType) {
            this.compareType = compareType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if(compareType.equalsIgnoreCase("name")) {
                return o1.name.compareTo(o2.name);
            } else if(compareType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.id - o2.id;
        }
    }

    private int id;
    private String name;
    private int yearStarted;

    public Employee() {

    }

    public Employee(int id, String name, int yearStarted) {
        this.id = id;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(id, name, yearStarted);
    }
}
