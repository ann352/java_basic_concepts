package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    //iterator help us to iterate over collection
    //every collection has itertor() method which returns Iterator object Iterator<TYPE_OF_COLLECTION>
    //Most often, an iterator is used in combination with a while loop
    //as long as there are next elements, move to the next one and return

    public static void main(String[] args) {

        //Important, the remove() method will only work if it is executed after calling the next() method
        //we cannot execute the remove() method twice in a row

        List<String> names = new ArrayList<>();
        names.add("Ania");
        names.add("Mania");
        names.add("Hania");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next(); //is good to put it to variable - e.g. when we wan't to do more operation than one on the element
            if (next.startsWith("Ania")) {  //else next() method will will point to the next element
                iterator.remove();
            }
        }

        //when we use in the program - while loop + iterator for the second time that wouldn't work
        //because iterator has finished iterating through the elements
        // NoSuchElementException - it is exception that could emerge when we have problem with iterator
        //if we want use iterator for the next time, we have to put it one more time in variable,or create new variable, like here:

        iterator = names.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
