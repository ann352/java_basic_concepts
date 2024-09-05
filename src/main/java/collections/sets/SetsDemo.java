package collections.sets;

import java.util.*;
import java.util.stream.Collectors;

public class SetsDemo {

    // before using a set for objects of a selected class, make sure you have implemented the hashCode and equals methods in that class.
    // we use sets when we want to have in collection unique elements (to do that, we have to override hashSet(), and equals() for our objects)
    // in sets order is not important, we can compare objects, eg: by using own implementation
    // of method equals() / hashcode() (numeric representation of object, that method is important in hashset),or by using Comparator and Comparable interfaces
    // sets have the same methods as interface collection

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Ola");
        names.add("Ala");
        names.add("Ala");
        names.add("Ula");
        names.add("Ela");
        names.add("Ela");

        System.out.println(names.toString());

        Set<User> users = new HashSet<>();
        users.add(new User("Adam", "Kot", "kot@gmail.com"));
        users.add(new User("Adam", "Kot", "psy@gmail.com"));
        users.add(new User("Adam", "Kot", "psy@gmail.com"));

        System.out.println(users.size()); //in setes order is not important and we don't have get() method

        //to display what we have in set, we should use for-each loop (that works for all the collections)

        for (User user : users) {
            System.out.println(user); //we have to override method toString() on User class to make it readable
        }

        //or iterator, example:
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) { //here we use while loop! Not 'if' instruction - we work until we have next element, not only one time - like with 'if'
            System.out.println(iterator.next());
        }

        //if we wan't to have some unique elements in list
        //we should done scenario: a) add elements to set, b)and later convert set to list

        Set<String> annimalsOnTheFarm = new HashSet<>();
        annimalsOnTheFarm.add("Cow");
        annimalsOnTheFarm.add("Horse");
        annimalsOnTheFarm.add("Cat");
        annimalsOnTheFarm.add("Cow");
        annimalsOnTheFarm.add("Cow");

        //we can transform set to list, in two ways:
        List<String> annimalList = new ArrayList<>(annimalsOnTheFarm);
        //with stream
        List<String> listOfAnnimals = annimalsOnTheFarm.stream().toList();
        System.out.println(listOfAnnimals);

        //we can at first put elements to set, and later to list

        Set<String> ordersWithoutDuplicates = new HashSet<>();
        ordersWithoutDuplicates.add("paper");
        ordersWithoutDuplicates.add("pens");
        ordersWithoutDuplicates.add("pens");

        System.out.println(ordersWithoutDuplicates);

        // sets have some implementation, e.g. hashset, linkedHashset, treeSet

        // a)hashSet - for hashSet crucial is method hash() - the main goal of that implementation is quick access to elements
        // or checking if they are in set or not, doesn't save order of elements
        // we check hash odf elements , if hashes are the same, we use  equals() method to check if that are the same objects or not

        // b)linkedHashSet - it saves uniqueness and order of added elements

        // c)TreeSet - we can add here objects that are Comparable, if we provide appropriate Comparator they will be added in order

        // getting elements from sets
        // 1) we can transform our set to list, and get elements by idexes:

        Set<String> dishesForQuests = new HashSet<>();
        dishesForQuests.add("lazania");
        dishesForQuests.add("pizza");
        dishesForQuests.add("hamburger");
        dishesForQuests.add("hamburger");
        dishesForQuests.add("pizza");

        ArrayList<String> listOfdishes = new ArrayList<>(dishesForQuests);
        System.out.println(listOfdishes.get(0));

        //2. we can use iterator
        Iterator<String> iterator1 = dishesForQuests.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        //3. or for-each loop
        for (String name : dishesForQuests) {
            System.out.println(name);
        }

        //removing element from set
        // 1. With Iterator - 'in-place' we are modyfying existing set

        System.out.println(users);
        Iterator<User> iterator2 = users.iterator();
        while (iterator2.hasNext()) {
            User next = iterator2.next();
            if (next.getName().equals("Adam"))
                iterator2.remove();
        }
        System.out.println(users);

        //when we want to use iterator for second time - we have to create new iterator, because the first works only one time
        Iterator<String> iterator3 = dishesForQuests.iterator();
        System.out.println("Removing with iterator" + dishesForQuests);
        while (iterator3.hasNext()) {
            String next = iterator3.next();
            if (next.equals("pizza")) {
                iterator3.remove();
            }
        }
        System.out.println(dishesForQuests);

        // 2.by stream - we are creating new set
        System.out.println("Removing with stream" + dishesForQuests);
        Set<String> smallerSetOfDishesforQuests = dishesForQuests.stream().
                filter(x -> !x.equals("lazania")).
                collect(Collectors.toSet());

        System.out.println(smallerSetOfDishesforQuests);

        //if we want to deduplicate list, we can use linkedHashSet - it saves order of unique elements

        List<User> userList = new ArrayList<>();
        userList.add(new User("Adam", "Moro", "adam@mail.com"));
        userList.add(new User("Ewa", "Moro", "ewa@mail.com"));
        userList.add(new User("Ewelina", "Moro", "ewa@mail.com")); // duplikat na mailu
        System.out.println(userList);
        Set<User> usersWithoutDuplicates = new LinkedHashSet<>(userList); // list to set
        userList = new ArrayList<>(usersWithoutDuplicates); //set to list

        //sorting - we can use TreeSet for objects which are Comparable and have own Comparator

        Set<User> usersNameSortedSet = new TreeSet<>(new UserNameComparator()); //in constructor we pass object of comparator
        // or faster - with using lambda
        //Set<User> usersNameSortedSet = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        usersNameSortedSet.add(new User("Zlatan", "Zidane", "zlatan@mail.com"));
        usersNameSortedSet.add(new User("Adam", "Smith", "adam@mail.com"));
        usersNameSortedSet.add(new User("Eva", "Fox","eva@mail.com"));
        System.out.println(usersNameSortedSet);

    }
}
