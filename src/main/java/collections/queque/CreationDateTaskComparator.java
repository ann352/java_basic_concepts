package collections.queque;

import java.util.Comparator;

public class CreationDateTaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.timeOfCreating.compareTo(o2.timeOfCreating);
    }
}
