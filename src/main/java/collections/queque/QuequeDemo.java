package collections.queque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QuequeDemo {
    //when the order of elements is important we use queque
    //is good to give the most general type of elements on the right side of expression like this:

    public static void main(String[] args) {
        Queue<String> ourQueque = new LinkedList<>();
        ourQueque.add("Ania");
        ourQueque.add("Bogdan");
        ourQueque.add("Magda");
        ourQueque.add("Zofia");

        //peek() - we only peek element from list
        ourQueque.peek();
        System.out.println(ourQueque);

        // poll() - we get first element from list
        ourQueque.poll();

//        //when we wan't to take element from queque to end we can use while-loop
//        while(!ourQueque.isEmpty()){
//            System.out.println("Witaj " + ourQueque.poll());
//        }
        System.out.println(ourQueque);

        //it is a bad idea to use for loop and dealing with loop which is decreasing

        //Deque - if we wan't take elements from the end
        Deque<String>namesFromTheEnd = new LinkedList<>();
        namesFromTheEnd.add("Tomas");
        namesFromTheEnd.add("Margaret");
        namesFromTheEnd.add("Antonio");

        while(!namesFromTheEnd.isEmpty()){
            System.out.println( "Hallo " + namesFromTheEnd.pollLast());
        }

        //we have also PriorityQoe from which we can take elements regarding it's priority





    }
}
