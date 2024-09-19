package streams;

import java.util.ArrayList;
import java.util.Arrays;

public class Examples {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("Honda", "Fiat", "Opel", "Nissan", "Peugeot"));
        cars.stream().
                map(n -> n.length())
                .filter(length -> length > 5)
                .forEach(x -> System.out.println(x));
    }
}
