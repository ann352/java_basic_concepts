package collections.comparator_comparable.comparator;

import java.time.LocalDateTime;

public class Task {
    int priority;
    String title;
    LocalDateTime creationDateTime;

    public Task(int priority, String title, LocalDateTime creationDateTime) {
        this.priority = priority;
        this.title = title;
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", title='" + title + '\'' +
                ", creationDateTime=" + creationDateTime +
                '}';
    }
}
