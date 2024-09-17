package collections.comparator_comparable.comparator;

import java.time.LocalDateTime;
import java.util.*;

public class ComparatorDemo {
    //if we implements Comparable we can use only one scenario of comparing
    //but Comparator - it is object that can compare other objects in many ways

    //class implementing Comparator is able to compare two objects - method compare takes them as parameters

    //public interface Comparator<T> {
    //    int compare(T o1, T o2);
    //}

    //Below example of a combination that first od Coparators
    //at first we look at the priority and then at the most recent task creation date

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(2,"P", LocalDateTime.of(2023,5,1,4,4)));
        tasks.add(new Task(5,"P", LocalDateTime.of(2024,10,1,1,4)));
        tasks.add(new Task(5,"P", LocalDateTime.of(2024,9,1,4,4)));

        Comparator<Task> compareByPriority = Comparator.comparing( Task::getPriority );
        Comparator<Task> compareByCreationDateTime = Comparator.comparing( Task::getCreationDateTime );

        Comparator<Task> taskComparator = compareByPriority.thenComparing(compareByCreationDateTime);
        Collections.sort(tasks,taskComparator);
        System.out.println(tasks);

        //Comparable and Comparator are mostly used in sorting methods available in the collections or in streams

    }


}
