package challenge2;
import java.util.*;
public class TaskData {

    public static final String allTasks = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;
    public static final String annTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            """;

    public static final String bobTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            """;

    public static final String carolTasks = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getTasksData(String name) {
        Set<Task> tasks = new HashSet<>();
        String owner = "ann,bob,carol".contains(name.toLowerCase()) ? name : "all";
        String selectedList = switch(owner.toLowerCase()) {
            case "ann" -> annTasks;
            case "bob" -> bobTasks;
            case "carol" -> carolTasks;
            default -> allTasks;
        };
        String[] data = selectedList.split("\n");
        String assignee = owner.equalsIgnoreCase("all") ? null : owner;
        for(String taskData : data) {
            String[] task = splitTaskData(taskData);
            Task.Status status = task.length <= 3
                    ? Task.Status.IN_QUEUE
                    : Task.Status.valueOf(task[3].replaceAll(" ", "_").toUpperCase());
            Task.Priority priority = Task.Priority.valueOf(task[2].toUpperCase());
            tasks.add(new Task(task[0], task[1], assignee, priority, status));
        }
        return tasks;
    }

    private static String[] splitTaskData(String taskData) {
       return Arrays.stream(taskData.split(",")).map(String::trim).toArray(String[]::new);
    }
}
