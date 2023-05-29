package com.dima;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] nums = {1, 2, 3, 4, 5, 4, 6, 5};

//        for (Integer i : nums) {
//            int result = i.compareTo(five);
//            System.out.printf("%d %s %d\n", i, result == 0 ? "=" : result > 0 ? ">" : "<", five);
//        }

        Student[] s = {new Student("Ron"), new Student("Jecky"), new Student("Anna"), new Student("Jack")};
//        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        Comparator<Student> gpaComparator = new StudentGPAComparator();

        Arrays.sort(s, gpaComparator.reversed());
        System.out.println(Arrays.toString(s));
    }
}
class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.getName()).compareTo(o2.gpa + o2.getName());
    }
}
class Student implements Comparable<Student> {
    private static Random random = new Random();
    private static int lastId = 1000;
    private String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        this.id = lastId++;
        this.gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%.2f)", id, name, gpa);
    }

    public String getName() {
        return name;
    }
}
