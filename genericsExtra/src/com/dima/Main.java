package com.dima;
import com.dima.model.LPAStudent;
import com.dima.model.Student;
import com.dima.util.QueryList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<LPAStudent> studentList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            studentList.add(new LPAStudent());
        }
//        printMoreList(studentList);
//        QueryList<LPAStudent> queryList = new QueryList<>(studentList);
//        printMoreList(queryList.getMatches("course", "java"));

        printMoreList(QueryList.getMatches(studentList, "course", "java"));


    }

    public static void printMoreList(List<? extends Student> list) {
        for(Student s : list) {
            System.out.println(s);
        }
    }

//    public static <T extends Student> void printList(List<T> list) {
//        for(Student s : list) {
//            System.out.println(s);
//        }
//        System.out.println();
//    }
}
