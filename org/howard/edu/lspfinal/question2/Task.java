package org.howard.edu.lspfinal.question2;

/**
 * single task - name, priority, astatus.
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * constructor
     * @param name 
     * @param priority 
     * @param status 
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
/**
 * gets name
 */
    public String getName() {
        return name;
    }
/**
 * get priority
 */
    public int getPriority() {
        return priority;
    }
/**
 * get status
 */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/**
 * override
 */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}