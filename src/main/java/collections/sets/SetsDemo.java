package collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetsDemo {

    // we use sets when we wan't to have in collection unique elements (to do that, we have to override hashSet(), and equals() for our objects)
    // in sets order is not important, we can compare objects, eg: by using own implementation
    // of method equals() / hashcode() (numeric representation of object, that method is important in hashset),or by using Comparator and Comparable interfaces

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Ola");
        names.add("Ala");
        names.add("Ala");
        names.add("Ula");
        names.add("Ela");
        names.add("Ela");

        System.out.println(names.toString());

        Set<User>users=new HashSet<>();
        users.add(new User("Adam","Kot","kot@gmail.com"));
        users.add(new User("Adam","Kot","psy@gmail.com"));
        users.add(new User("Adam","Kot","psy@gmail.com"));

        System.out.println(users.size()); //in setes order is not important and we don't have get() method

        //to display what we have in set, we should use for-each loop (that works for all the collections)

        for(User user : users){
            System.out.println(user); //we have to override method toString() on User class to make it readable
        }

        //or iterator, example:
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){ //here we use while loop! Not 'if' instruction - we work until we have next element, not only one time - like with 'if'
            System.out.println(iterator.next());
        }

        //sets have some implementation, e.g. hashset, linkedHashset, treeSet
        //hashSet - for hashSet crucial is method hash() - the main goal of that implementation is quick access to elements or checking if they are in set or not
        //we check hash odf elements , if hashes are the same, we use  equals() method to check if that are the same objects or not
        //linkedHashSet - works like hashSet but additionally store element regarding of it's order of insert





    }
}
