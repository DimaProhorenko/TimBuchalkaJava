package challenge.model;

import challenge.util.QueryItem;

import java.util.*;

public class Student implements QueryItem, Comparable<Student> {
    private UUID id;
    private static long counter = 0;
    private long ID;
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private String[] names = {"Ann", "Marry", "Tim", "Jerryl", "Morthy"};
    private String[] courses = {"C++", "Java", "C#"};

    public Student() {
        id = UUID.randomUUID();
        ID = counter++;
        int lastNameIndex = random.nextInt(65, 91);
        name = names[random.nextInt(names.length)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(courses.length)];
        yearStarted = random.nextInt(2018, 2023);
    }


    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.getId());
//        return Long.valueOf(ID).compareTo(Long.valueOf(o.ID)) * -1;
    }
    @Override
    public String toString() {
        return String.format("%-5d %-15s %-15s %d", ID, name, course, yearStarted);
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

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public UUID getId() {
        return id;
    }
}
