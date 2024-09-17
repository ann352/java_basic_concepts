package collections.comparator_comparable.comparator;

import collections.comparator_comparable.comparable.Task;

import java.util.Comparator;

class PriorityComparator implements Comparator<Task> {
    public int compare(Task o1, Task o2) {
        return o1.priority - o2.priority;
    }
}
