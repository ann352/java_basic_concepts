package streams;

public class Car {
    String name;
    String colour;
    String fuel;

    public Car(String name, String colour, String fuel) {
        this.name = name;
        this.colour = colour;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
