package streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        // we can uderstand that lambda as equivalent to the "traditional" for-each loop

        List<String> colours = Arrays.asList("green", "black", "blue", "yellow", "white");
        colours.stream().forEach(x -> System.out.println(x + " "));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream().forEach(x -> System.out.println("Result: " + x * 2));
        //forEach(...) terminates the stream so no further operations ("stations") can be placed after it - it must be the last operation

        //filter()
        //only elements that meet the given condition will pass through the filter

        //a)interface Predicate
        //we define condition which element of a given type must meet
        //we implement method t (using lambda), that takes an object being tested and is supposed to return a boolean value
        //- whether this object meets the condition or not

        Predicate<Integer> isEvenPredicate = n -> n % 2 == 0;
        Predicate<String> isLongerThan4Chars = s -> s.length() > 4;

        //Predicate + filter(...)
        //if we pass predicate to filter(...) method, only elements that meet predicate will go to the next part of the stream

        //a) predicate in variable
        ArrayList<String> texts = new ArrayList<>(Arrays.asList("Ola", "ma", "kota", "Mruczka"));
        Predicate<String> isLongerThan3Chars = s -> s.length() > 3;

        texts.stream()
                .filter(isLongerThan3Chars)
                .forEach(s -> System.out.println(s));

        //b) // predicate defined directly with lambda in filter method

        texts.stream().filter(x -> x.startsWith("O"))
                .forEach(x -> System.out.println(x));

        //peek()
        //it behaves like forEach() and use Consumer too, but the biggest differnce between those two methods:
        //peek(...) method DOES NOT TERMINATE the stream (unlike forEach(...)) - can be used to perform operation on element inside the stream
        //thanks to peek() we can observe how stream operations are performed one by one, e.g. printing an element before and after filtering
        List<Integer> numbers1 = Arrays.asList(5, 2, 6, 9, 4, 8);

        texts.stream()
                .peek(n -> System.out.println("Przed filtrowaniem: " + n))
                .filter(n -> n.startsWith("O"))
                .forEach(n -> System.out.println("Po filtrowaniu: " + n));
        //here is analogy to a production line: all operations are performed on a single element instead of waiting for one operation to be performed on all of elements

        //map()
        //is used when we need to replace all objects with "something else"
        //mapping - transforming/changing objects into another.Term comes from maps (e.g. HashMap), because that's what maps are really for
        //If we have a Map<String, Double> containing data about currency("USD" -> 3.8, "EUR" -> 4.2)we can say that it is used to convert currency code to its conversion number

        List<Car> cars = Arrays.asList(new Car("Honda", "red", "LPG"), new Car("Nissan", "grey", "LPG"));
        cars.stream().map(Car::toString)
                .forEach(System.out::println);

        //interface Function - we define in map() in which way and to which type we should convert an element (T to R)
        //public interface Function<T, R> {
        //    R apply(T t);

        Function<String, String> changeToUpperCase = s -> s.toUpperCase();
        Function<String, Integer> changeToLength = s -> s.length();

        System.out.println("--- map to upper case ---");
        String mappedToUpperCase = changeToUpperCase.apply("Java");
        System.out.println(mappedToUpperCase);

        System.out.println("--- map to length ---");
        Integer mappedToLength = changeToLength.apply("Java");
        System.out.println(mappedToLength);
        //Function + map(...)
        //map(...) accepts a Function interface - lambda defines to what turn each object in the stream into

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers3.stream()
                .map(n -> n * n) // every number is convert to square of that number
                .forEach(n -> System.out.println(n));

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers4.stream()
                .peek(n -> System.out.println("Before mapping: " + n))
                .map(n -> n * n)
                .forEach(n -> System.out.println("After mapping: " + n));

        //collect() -> is used to collect stream elements
        //has 2 versions -> one takes Collector - containing the logic of "how and for what to collect the elements"
        //most commonly used collectors

        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 87, 8, 40);

        //Collectors.toList()
        List<Integer> collectList = list.stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collectList);

        //Collectors.toSet()
        Set<Integer> collectSet = list.stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(collectSet);

        //Collectors.joining(...)

        //joining collector is used to join Strings by given separator (as a parameter of the joining()
        //names.stream().collect(Collectors.joining(",")) returns String that contains names joined together using comma
        //joining() without any parameter returned Strings joined without any separator.

        List<String> dishes = Arrays.asList("spagetti", "pizza", "hot-dog", "hamburger");
        String longerText = dishes.stream()
                .filter(dish -> dish.length() > 5)
                .map(n -> n.toUpperCase())
                .collect(Collectors.joining("..."));
        System.out.println(longerText);
        //Important!
        //joining() collector should only be used on streams with String elements - for different type - they will be converted to String by method toString()

        //Collectors.groupingBy(...)
        //allows to collect stream elements into a map, grouping them according to a given feature

        //e.g. if we want to group users by city, i.e. we need a list of people from each city who come from it,
        //then we can create a Map<String,List<User>> -> String - city name, and the value is List<Customer> i.e. a list of customers from given city
        HashMap<String,List<User>> users = new HashMap<>();
        users.put("Warszawa",new ArrayList<>(Arrays.asList(new User("Tom",30,"Moro"), new User("Anna",20,"Smith"))));

        //groupingBy() - allows to group elements from a user stream by a given feature (city field)
        //and we get a Map<String, List<User>> with needed data
        //we pass here lambda of type Function like in mapping but difference is that now we define
        //"by which field group the stream elements for us" (c -> c.getCity() - for each user c, group by its city c.getCity())

        ArrayList<User> users1 = new ArrayList<>(Arrays.asList(new User("Tom", 50, "Warszawa"), new User("Anna", 60, "Warszawa"), new User("John", 30, "Krakow"), new User("Anna", 20, "Krakow")));
        //here is created a map from stream
        Map<String, List<User>> usersByCity = users1.stream().collect(Collectors.groupingBy(x -> x.city));
        System.out.println(usersByCity);

        //here we get by key "Warszawa" list of users from that city
        List<User> usersFromWarszawa = usersByCity.get("Warszawa");
        System.out.println(usersFromWarszawa);
    }
}
