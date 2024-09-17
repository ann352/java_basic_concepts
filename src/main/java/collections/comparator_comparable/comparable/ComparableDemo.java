package collections.comparator_comparable.comparable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

    //comparable is simple , fuctional interface with method compareTo()
    //we should implememnts its method when creating given class

    //public interface Comparable<T> {
    //    public int compareTo(T o);
    //}

    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1,"A", LocalDateTime.of(2023,1,2,9,7)));
        taskList.add(new Task(2,"B", LocalDateTime.of(2022,1,2,9,7)));
        taskList.add(new Task(1,"C", LocalDateTime.of(2024,1,2,9,7)));

        //when we implement Comparable interface in our class and use sorting method,
        //elements will be sorted according implementation compareTo() method

        Collections.sort(taskList); //priority later date of creation
        System.out.println(taskList);

    }



}
