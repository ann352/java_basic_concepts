package collections.maps;

import java.util.*;

public class MapsDemo {
    public static void main(String[] args) {

        //technically map doesn't extends interface collection,
        //maps are used to store pairs of elements - key and value, here crucial is a speed of getting elements, e.g. configuration of application (database : address)
        //we create a map by specifying the key and value type
        //we can create map, in which under one key could be many lists with String. e.g. one word and many definition -> Map<String,List<String>>



        Map<String,Integer> names = new HashMap<>();

        //methods
        //put() - to insert a value
        names.put("Ania", 14);
        names.put("Ola", 20);
        names.put("Tomek", 30);

        //V get(K key) - to get a value under key, or null if key doesn't exist
        System.out.println(names.get("Ania"));

        //boolean containsKey(K key) - to chceck if set contains given key / or containsValue()
        System.out.println(names.containsKey("Ania"));

        //V getOrDefault(Object key, V defaultValue) - when key is not present is returned default value

        //boolean isEmpty() - we now if map is empty

        //iterating over maps

        //1.Map.entrySet() - it returns set of entries(key+value) type Map.Entry (nested class)

        Set<Map.Entry<String, Integer>> entries = names.entrySet(); //over entries we can iterate by using for-each, or Iterator

        // iterating over set by Iterator
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+ " " + next.getValue());
        }

        // itrrating over set by for-each loop
        for(Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //2. getting set of keys ->  Set<K> keySet()
        System.out.println(names.keySet());

        //3.getting collection of values ->  Collection<V> values()
        System.out.println(names.values());

        //void putAll(Map<? extends K,? extends V> m) - we add elements from other map

        //V putIfAbsent(K key, V value) - added new value if key is absent

        //V remove(Object key)

        //int size() - it returned size of map

        //Collection<V> values() - returns us a collection with all values, i.e. only values without keys

        //choosen implementation of maps
        //HashMap - is fast , but order od elements is random
        //LinkedHashMap - is fast, we get elements according to order of putting elements
        //TreeMap - is good solution when we want get sorted entries, keys have to implements Comparable,
        //or by creating TreeMap we have to put Comparator in constructor

        //if map has duplicated keys - problem can be incorrectly overridden implementations of equals() and hashCode() methods
        Map <User, Boolean> activeUsers = new HashMap<>();
        User u1 = new User("Adam","Moro","a.moro@gmail.com");
        User u2 = new User("Ada","Moro","a.moro@gmail.com");
        User u3 = new User("Anna","Moro","a.moro@gmail.com");

        activeUsers.put(u1, true);
        activeUsers.put(u2, true);
        activeUsers.put(u3, true);

        //we have only one user in map, because we properly override equals() and hashcode() in users and we check only email of user
        System.out.println(activeUsers);

        //Adding multiple objects to one key
        //Formally, there can't be many objects under one key.
        //but we can make the values be lists and the problem is solved

        Map<String, List<Integer>> subjectGrades = new HashMap<>();
        addAnotherRating(subjectGrades, "polski", 3);
        addAnotherRating(subjectGrades, "polski", 4);
        addAnotherRating(subjectGrades, "polski", 5);
        addAnotherRating(subjectGrades, "matematyka", 2);

        System.out.println(subjectGrades);

        //Iterating over elements
        //we can get set of entries from map with method ->  entrySet()
        //and go over every Map.Entry using getKey and getValue methods

        Map <String, Integer> grades = new HashMap<>();
        grades.put("polish",4);
        grades.put("english",5);
        grades.put("german",4);

        Set<Map.Entry<String, Integer>> entries1 = grades.entrySet();
        for(Map.Entry<String, Integer> entry : entries1){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }

        //Removing elements -> we use method remove() which return that element
        grades.remove("polish");
        System.out.println(grades);

        //sorting
        //to sort the entries in the map by key we can use TreeMap implementation, but the key class must implement the Comparable interface,
        //or when creating the TreeMap, provide an appropriate Comparator object in the constructor

        Map<String, String> animals = new TreeMap<>();
        animals.put("bee","insect");
        animals.put("cat","mammal");
        animals.put("parrot","bird");

        animals.entrySet().stream().map(x->x.getKey()+"" +x.getValue()).forEach(System.out::println);




    }

    public static void addAnotherRating(Map<String, List<Integer>> subjectGrades, String subject, Integer rating) {
        if (subjectGrades.containsKey(subject)) {
            subjectGrades.get(subject).add(rating);//we get list under key and add value
        } else {
            subjectGrades.put(subject, new ArrayList<>(Arrays.asList(rating)));
            // new ArrayList<>(Arrays.asList(rating)) - new modifical list with one  element
            // Arrays.asList(rating) - return unmodifical list
        }
}}
