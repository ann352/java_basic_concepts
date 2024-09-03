package collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapsDemo {
    public static void main(String[] args) {

        //technically map doesn't extends interface collection,
        //maps are used to store pairs of elements - key and value, here crucial is a speed of getting elements, e.g. configuration of application (database : address)
        //we create a map by specifying the key and value type

        Map<String,Integer> names = new HashMap<>();

        //methods
        //put() - to insert a value
        names.put("Ania", 14);
        names.put("Ola", 20);
        names.put("Tomek", 30);

        //V get(K key) - to get a value under key
        System.out.println(names.get("Ania"));

        //boolean containsKey(K key) - to chceck if set contains given key / or containsValue()
        System.out.println(names.containsKey("Ania"));

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

        //3/getting collection of values ->  Collection<V> values()
        System.out.println(names.values());



    }
}
