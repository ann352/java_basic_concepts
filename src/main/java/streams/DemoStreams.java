package streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DemoStreams {
    public static void main(String[] args) {
        //creating streams

        //.stream  -> basic way, used in collections: sets, lists, queque
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Eva", "Martha", "Sonia", "Merry", "Jane"));
        Stream<String> stream = names.stream();

        //creating stream from map -> at first we use setEntry(), later stream method
        HashMap<String, Integer> salaries = new HashMap<>();
        salaries.put("Sophie", 4700);

        Stream<Map.Entry<String, Integer>> stream1 = salaries.entrySet().stream();

        //converting an array to a stream
        //we convert any array to a stream using the java.util.Arrays.stream(ARRAY) method
        String[] animals = {"cow", "lion", "fox", "bear", "elephant"};
        Stream<String> stream2 = Arrays.stream(animals);
        //Converting an int[] or double[] array to a stream creates IntStream and DoubleStream, respectively

        //Creating a stream from objects - for a few elements we can do it directly
        Stream<String> text = Stream.of("We", "are", "listen", "to", "music");

        //methods
        //forEach(Consumer <T> consumer) -> pozwala wykonać operację na każdym elemencie
        text.forEach(System.out::println);
        //It is a functional interface with one method - void accept(T t), where T is the type we want to operate on.
        //It is used to "pass a method to be called on the element t"

        //String consumer - when executed on some String - it will print it to the screen
        Consumer<String> printString = x -> System.out.println(x);

        //Consumer + forEach(...)
        //We already know that the forEach(...) method requires a "consumer", which is a lambda that accepts one element and performs the desired operation on it
        //Calling this method on a stream causes the passed lambda to be called on each element of the stream

        List<String> colours = Arrays.asList("green", "black", "blue", "yellow", "white");
        colours.stream().forEach(x-> System.out.println(x + " "));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream().forEach(x-> System.out.println( "Result: " + x*2 ));



    }
}
