package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * hashmap for colelction of tasks
 */
public class TaskManager {
    private Map<String, Task> taskMap = new HashMap<>();

    /**
     * adds the task to the manager
     * @param name 
     * @param priority 
     * @param status 
     * @throws DuplicateTaskException 
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        taskMap.put(name, new Task(name, priority, status));
    }

    /**
     * retrives the tas y name
     * @param name 
     * @return 
     * @throws TaskNotFoundException 
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!taskMap.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return taskMap.get(name);
    }

    /**
     * updates satus
     * @param name 
     * @param status 
     * @throws TaskNotFoundException 
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * print tasks group by status
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new TreeMap<>();
        for (Task task : taskMap.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> list = grouped.getOrDefault(status, new ArrayList<>());
            for (Task t : list) {
                System.out.println("  " + t);
            }
        }
    }
}
