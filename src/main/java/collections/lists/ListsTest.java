package collections.lists;

import java.util.*;

public class ListsTest {

    //the most popular type of collection,allow to add any number of data and remember the order of added items
    //they allow to refer to them using indexes, we don't have to specify an initial size for
    //it will automatically grow if you add an item to it and shrink if we remove it
    // List - it is interface - we can't create object List, but we can create it's implementation
    // e.g. LinkedList, or ArrayList

    public static void main(String[] args) {

        //methods used in lists, common for all collections

        List<String> names = new ArrayList<>();
        List<String> englishNames = new ArrayList<>();

        //1.add()
        names.add("Ania");
        names.add("Czesia");
        names.add("Ania");
        names.add("Hania");
        names.add("Basia");
        names.add("Kuba");
        names.add("Kuba");

        englishNames.add("Elizabeth");
        englishNames.add("Noah");
        englishNames.add("Ann");
        englishNames.add("John");

        //addAll() -> we add elements from other collection
        boolean b = names.addAll(englishNames);

        //containsAll() -> we check if we have alements from other collection;
        boolean c = names.containsAll(englishNames);
        System.out.println(c);

        //2.size()
        int size = names.size();
        System.out.println(size);

        //3.isEmpty()
        System.out.println(names.isEmpty());

        //4.contains()
        System.out.println(names.contains("Ania"));

        //5.remove() -> remove and returns that element
        System.out.println(names.remove("Ania"));
        System.out.println(names.contains("Ania"));

        //removeAll()
        boolean b1 = names.removeAll(englishNames);
        System.out.println("List names is cleared from english names? " + b1);

        //6.clear()
        System.out.println(englishNames);
        englishNames.clear();
        System.out.println(englishNames);

        //7.size()
        System.out.println(englishNames.size());
        System.out.println(englishNames.add("Tom"));
        System.out.println(englishNames);

        //8.T[] toArray(T[] a) -> we can transform array to list
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("strawberry", "apple", "coconut"));
        String[] namesArr = fruits.toArray(new String[0]);
        System.out.println(namesArr);
        //we have here special notation, the reason of that is fact that method toArray is generic,
        //and can change table of String to new table with different type, e.g. to Object
        //with 'new String[0]' notation - we say Java - type of result table

        //and also array to list, with below static method
        String[] namesArray = {"Adam","Ewa","Kacper"};
        System.out.println("List from Array" + Arrays.asList(namesArray));

        //we can also crate list like that:
        List<String> list = Arrays.asList("Ela", "Hela");
        System.out.println("New list: " + list) ;
        //the list that is created after using Arrays.asList
        //has a specific implementation that does not allow adding new elements or removing them
        //when we conduct that operation we get UnsupportedOperationException

        //If we want to have modifiable list, we should repack it into chosen "normal" implementation
        ArrayList<String> strings = new ArrayList<>(list);

        //iterator()
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toUpperCase());
        }

        //additional methods - specific only for in lists - that operate on indexes

        // E - type of element, e.g. E get(int index)
        System.out.println("First element of 'names': " + names.get(0)); //first element
        System.out.println("Last element of 'names': " + names.get(names.size() -1));//last element

        // indexOf() -> it returns first index of element
        System.out.println("First index of ania " + names.indexOf("Ania")); //if element doesn't exist it returns -1,

        // lastIndexOf() -> it returns first index of element
        System.out.println("Last index of ania " + names.lastIndexOf("Ania")); //if element doesn't exist it returns -1,

        // void add(int index, E element)
        names.add(1, "Tomasz");
        System.out.println(names);

        // set()  replace element with given index, returns the element that was replaced (old value)
        names.set(1, "Kuba");
        System.out.println(names);

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

        //iterator
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()){
            System.out.println(namesIterator.next());
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

        //listiterator() -> it returns iterator that can going to previous / next
        ListIterator<String> stringListIterator = names.listIterator();

        //sort(Comparator<? super E>)
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

    //List subList(int fromIndex, int toIndex)
        System.out.println(names.subList(1,3));
    }
}

