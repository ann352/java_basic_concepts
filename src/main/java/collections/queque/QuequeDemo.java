package collections.queque;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        //E element() and E peek(), the first one will throw an exception when there is nothing to download, the second one will return null. Here it is up to you to decide how you want to be informed about downloading a non-existent element.

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
        //Queue extends Collection and Deque extends Queue - so we have here the same methods as in the Collection
        Deque<String> namesFromTheEnd = new LinkedList<>();
        namesFromTheEnd.add("Thomas");
        namesFromTheEnd.add("Margaret");
        namesFromTheEnd.add("Antonio");

        while (!namesFromTheEnd.isEmpty()) {
            System.out.println("Hallo " + namesFromTheEnd.pollLast());
        }

        //push() - addFirst() and push() do the same
        namesFromTheEnd.push("Lorenzo");
        // other important methods in Deque are : poolFirst() , peekFirst(), peekLast(), void addFirst(E element), addLast(E element)
        // getFirst(), getLast(), removeFirst(), removeLast()
        //we have also PriorityQoe from which we can take elements regarding it's priority


        //pop() - it get and remove forst element
        System.out.println(namesFromTheEnd.pop());
        System.out.println(namesFromTheEnd);

        //pop() - for empty quque it will throw NosuchElementException

        //offer()
        namesFromTheEnd.offer("David");
        System.out.println(namesFromTheEnd);

        //results of adding elements in queque with different methods
        Deque<String> deque = new LinkedList<>();
        deque.push("txt1");
        deque.addFirst("txt2"); // act like push , add element to the beginning of queque
        deque.add("txt3"); //  add element to the end
        System.out.println(deque);
        // result: [txt2, txt1, txt3]

        //push and addFirst work the same way implementing LIFO (first in last out) queue behavior
        //using the add method allows us to achieve FIFO (first in first out) queue behavior

        //gettings elements from queque
        //most common scenario is getting items one by one, from the beginning or the end. However, there are a few issues that require us to look at element first
        //we use the poll() when we want to get something out - and the peek() when we want to take a look
        //In Deque there are also directional variants:
        //peekFirst, peekLast
        //pollFirst, pollLast

        // to look through the queue, we can 3 solutions:
        //iterator

        Deque<String> flowersName = new LinkedList<>(Arrays.asList("rose","cornflower", "sunflower", "tulp"));

        Iterator<String> iterator = flowersName.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //for-each loop
        for(String nameOfFlower : flowersName){
            System.out.println(nameOfFlower);
        }
        //foreach loop is not suitable for viewing and modifying the queue simultaneously, e.g. with poll()

        //stream
        flowersName.stream().
                forEach(System.out::println);

        //Removing from the queue
        //In the case of a queue, it is not possible to remove selected elements positionally (except for the end and beginning)
        //is better to create a new queque from filtered elements
        Deque<Integer>numbers = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> collectedelements = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        LinkedList<Integer> integers = new LinkedList<>(collectedelements);
        System.out.println(integers);

        //Chosen implementation
        //LinkedList used in Deque and Quque - implements List, Queque and Deque interface
        //PriorityQue used only by QueQue - we take elements according to its priorities - objects must implemeents Comparable or Comparator interface

        //PriorityQue - comparing elements
        List<Task> taskList = new LinkedList<>(Arrays.asList(
                new Task("AAA",3, LocalDate.of(2024,11,1)),
                new Task("BBB",5,LocalDate.of(2024,12,11)),
                new Task("CCC",0,LocalDate.of(2024,01,30))
        )); //the lowest number of urgency decide what is first

        //here we compare tasks due the urgency
        PriorityQueue<Task> urgencyQueue = new PriorityQueue<>(taskList); //we create PriorityQuque and put comparable list of objrcts to its consructor
        System.out.println("urgency:"+ urgencyQueue);

        //here we compare tasks due the urgency
//        PriorityQueue<Task> creationDateTaskQueque = new PriorityQueue<>(new CreationDateTaskComparator());
//        System.out.println(creationDateTaskQueque);

        //or with lambda
        Comparator<Task> dateTaskComparator = (t1,t2) -> t1.timeOfCreating.compareTo(t2.timeOfCreating);
        PriorityQueue<Task> oldestQueue = new PriorityQueue<>(dateTaskComparator);
        System.out.println(oldestQueue);
    }
}
//we use queque when we want to remove some elements from the collection one by one by processing them
//If we want to process the elements of the collection but not remove them, it is better to use lists


