package collections.queque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QuequeDemo {

    //when the order of elements is important we use queque
    //in queues we have access, only to the first or last element
    //is good to give the most general type of elements on the right side of expression like this:

    public static void main(String[] args) {
        Queue<String> ourQueque = new LinkedList<>();
        ourQueque.add("Ania");
        ourQueque.add("Bogdan");
        ourQueque.add("Magda");
        ourQueque.add("Zofia");

        //peek() - we only peek element from list - it returns null if queque is empty
        ourQueque.peek();
        System.out.println(ourQueque);

        //element() - we only peek element from list - it returns exception if queque is empty

        // poll() - we get first element from list
        ourQueque.poll();

        //remove() -  it remove and retirns first element from list - if queque is empty it returns exception

//        //when we wan't to take element from queque to end we can use while-loop
//        while(!ourQueque.isEmpty()){
//            System.out.println("Witaj " + ourQueque.poll());
//        }
        System.out.println(ourQueque);

        //example
        Queue songs = new LinkedList<>(); //we can put here LinkerdList bacause it implements interfaces List, Queque, Deque
        songs.add("Andżeju");
        songs.add("Cocojumbo");
        songs.add("Sokoły");
        songs.add("Andrzela");

        System.out.println("Playlist for today: " + songs);
        for (int i = 0; i <= songs.size(); i++) {
            System.out.println("gram: " + songs.poll() + " [następnie: " + songs.peek() + "]");
        } //with poll() when element is taken from queque and with peek() next is only peecked


        //it is a bad idea to use for loop and dealing with loop which is decreasing

        //Deque - it is extention of Quque - here we can take elements from beginning or from the end of queque
        Deque<String> namesFromTheEnd = new LinkedList<>();
        namesFromTheEnd.add("Thomas");
        namesFromTheEnd.add("Margaret");
        namesFromTheEnd.add("Antonio");

        while (!namesFromTheEnd.isEmpty()) {
            System.out.println("Hallo " + namesFromTheEnd.pollLast());
        }

        //push()
        namesFromTheEnd.push("Lorenzo");
        // other important methods in Deque are : poolFirst() , peekFirst(), peekLast(), void addFirst(E element), addLast(E element)
        // getFirst(), getLast(), removeFirst(), removeLast()
        //we have also PriorityQoe from which we can take elements regarding it's priority


        //pop() - it get and remove forst element
        System.out.println(namesFromTheEnd.pop());
        System.out.println(namesFromTheEnd);

        //pop() - for empty quque it will throw NosuchElementException

    }
}
