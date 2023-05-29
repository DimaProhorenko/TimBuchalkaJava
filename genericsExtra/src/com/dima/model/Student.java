package com.dima.model;

import com.dima.util.QueryItem;

import java.util.Arrays;
import java.util.Random;

public class Student implements QueryItem {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private String[] names = {"Ann", "Marry", "Tim", "Jerryl", "Morthy"};
    private String[] courses = {"C++", "Java", "C#"};

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = names[random.nextInt(names.length)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(courses.length)];
        yearStarted = random.nextInt(2018, 2023);
    }


    @Override
    public String toString() {
        return String.format("%-15s %-15s %d", name, course, yearStarted);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
