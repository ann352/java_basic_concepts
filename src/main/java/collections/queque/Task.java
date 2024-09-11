package collections.queque;

import java.time.LocalDate;

public class Task implements Comparable <Task> {

    String title;
    int urgency;
    LocalDate timeOfCreating;

    public Task(String title, int urgency, LocalDate timeOfCreating) {
        this.title = title;
        this.urgency = urgency;
        this.timeOfCreating = timeOfCreating;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", utrgency=" + urgency +
                ", timeOfCreating=" + timeOfCreating +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.urgency - o.urgency;
    }
}
