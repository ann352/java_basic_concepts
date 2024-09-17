package collections.comparator_comparable.comparable;

import java.time.LocalDateTime;

public class Task implements Comparable<Task>{
    public int priority;
    String title;
    public LocalDateTime creationDateTime;

    public Task(int priority, String title, LocalDateTime creationDateTime) {
        this.priority = priority;
        this.title = title;
        this.creationDateTime = creationDateTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", title='" + title + '\'' +
                ", creationDateTime=" + creationDateTime +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        int priorityDiff = o.priority - this.priority; //bigger number is first
        if (priorityDiff != 0) {
            return priorityDiff;
        } else {
            return this.creationDateTime.compareTo(o.creationDateTime);
        }
    }
}
