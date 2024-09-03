package collections.iterator.iterator_tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveStringsWithIterator {

    public static void main(String[] args) {
        List<String> exampleList = new ArrayList<>();
        exampleList.add("abba");
        exampleList.add("Anna");
        exampleList.add("Joanna");
        exampleList.add("Jan");
        exampleList.add("Olek");

        System.out.println("List after transformation: " + removeElements(exampleList, 4));
    }

    public static List<String> removeElements(List<String> list, int length) {
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().length()==length){
                iterator.remove();
            }
        }
        return list;
    }
}

