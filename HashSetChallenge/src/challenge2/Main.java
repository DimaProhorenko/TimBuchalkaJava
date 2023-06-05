package challenge2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Set<Task> annTasks = TaskData.getTasksData("ann");
       Set<Task> bobTasks = TaskData.getTasksData("bob");
       Set<Task> carolTasks = TaskData.getTasksData("carol");
       Set<Task> bossTasks = TaskData.getTasksData("all");


       Set<Task> allTasks = getUnion(bossTasks, annTasks, bobTasks, carolTasks);
       sortAndPrint("Union of tasks", allTasks);

       Set<Task> intersection = getIntersection(annTasks, bobTasks);
       sortAndPrint("Intersection", intersection);

       Set<Task> difference = getDifference(annTasks, bobTasks);
       sortAndPrint("Difference", difference);
    }

    public static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }


    public static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> comparator) {
        String separator = "-".repeat(90);
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(comparator);
        list.forEach(System.out::println);
    }

    public static Set<Task> getUnion(Collection<Task>... collections) {
        Set<Task> allTasks = new HashSet<>();
        for(Collection<Task> collection : collections) {
            allTasks.addAll(collection);
        }
        return allTasks;
    }

    public static Set<Task> getIntersection(Set<Task> a, Set<Task> b) {
        Set<Task> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
}
