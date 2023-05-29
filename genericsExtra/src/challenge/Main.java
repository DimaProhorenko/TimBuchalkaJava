package challenge;

import challenge.model.LPAStudent;
import challenge.model.Student;
import challenge.util.QueryList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var queryList = new QueryList<>(generateStudents(25));
        var studentsToExpell = queryList.getMatches("completed", "50").getMatches("course", "java");
        printList(queryList);
        System.out.println("\nStudents to expell ->\n");
//        printList(Collections.sort(studentsToExpell , LPAStudent.getCompletionComparator()));
//        Collections.sort(studentsToExpell, LPAStudent.getCompletionComparator());
        studentsToExpell.sort(LPAStudent.getCompletionComparator());
        printList(studentsToExpell);
    }

    public static void printList(List<? extends Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }

//    public static <T extends Student> List<T> generateStudents(int studentsCount) {
//        List<T> list = new ArrayList<>();
//        for (int i = 0; i < studentsCount; i++) {
//            list.add((T) new LPAStudent());
//        }
//        return list;
//    }

    public static List<LPAStudent> generateStudents(int studentsCount) {
        List<LPAStudent> list = new ArrayList<>();
        for (int i = 0; i < studentsCount; i++) {
            list.add(new LPAStudent());
        }

        return list;
    }
}
