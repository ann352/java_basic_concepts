package collections.comparator_comparable.comparator;

import java.util.Comparator;

class CreationComparator implements Comparator<Task> {
    public int compare(Task o1, Task o2) {
        return o1.creationDateTime.compareTo(o2.creationDateTime);
    }

    //Creating two separate Comparators gives us a lot of flexibility
    //mainly due to the additional default methods of the Comparator interface:

    //1) e.g reverse() returned Comparator with reversed logic
    //2) Comparator<Task> thenComparing(Comparator<? super Task> other:
    //allows to define any combination of multiple comparators.It's like sorting: first check priority,then check time,etc.
}

