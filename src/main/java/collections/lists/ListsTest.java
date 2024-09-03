package collections.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListsTest {

    //the most popular type of collection,allow to add any number of data and remember the order of added items
    //they allow to refer to them using indexes, we don't have to specify an initial size for
    //it will automatically grow if you add an item to it and shrink if we remove it
    // List - it is interface - we can't create object List, but we can create it's implementation
    // e.g. LinkedList, or ArrayList

    public static void main(String[] args) {

        //methods used in lists, common for all collections

        List<String> names = new ArrayList<>();

        //1.add()
        names.add("Ania");
        names.add("Hania");
        names.add("Basia");
        names.add("Kuba");
        names.add("Kuba");

        //2.size()
        int size = names.size();
        System.out.println(size);

        //3.isEmpty()
        System.out.println(names.isEmpty());

        //4.contains()
        System.out.println(names.contains("Ania"));

        //5.remove()
        System.out.println(names.remove("Ania"));
        System.out.println(names.contains("Ania"));

        //additional methods - specific only for in lists - that operate on indexes

        //6. E - type of element, e.g. E get(int index)
        System.out.println(names.get(0));

        //7. indexOf()
        System.out.println(names.indexOf("Hania")); //if element doesn't exist it returns -1,

        //8. void add(int index, E element)
        names.add(1, "Tomasz");
        System.out.println(names);

        //9.set()  replace element with given index, returns the element that was replaced (old value)
        names.set(1, "Kuba");
        System.out.println(names);

        //10.iterator()
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toUpperCase());
        }

        //printing , iterating over lists

        //1. we can directly print list in println, because lists have own toString()
        System.out.println(names);

        //2.in loop - when we wan't to display something in different way

        //for
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        //for-each
        for (Object name : names) {
            System.out.println(name);
        }

        //removing elements from list in loop
        //we shouldn't use for-each loop - it is used usually used to view elements, it can cause an exception
        //to avoid error we van add here 'break' but in for-each we can remove only one value
        //generally we have problems in that loop because it is constantly smaller and we always go to the next element

        for (Object element : names) {
            if (element.equals("Kuba")) {
                names.remove(element);
                break; //we have to use break here
            }
        }
        System.out.println(names);

        //proper way: we can use for-loop

        for(int i =0; i < names.size() ; i++){
            if (names.get(i).equals("Kuba")) {
                names.remove(i);
                i--; //we have to undo iterator
            }
        }
        System.out.println(names);
    }


}

