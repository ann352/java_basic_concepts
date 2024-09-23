package oop;

public class Car {

    private String name;
    private int fuel;
    private int maxSpeed;


    public String getName() {
        return name;
    }

    public int getFuel() {
        return fuel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Car(String name, int fuel, int maxSpeed) {
        this.name = name;
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
    }

    public void refuel(int newFuel){
        fuel = fuel + newFuel;
    }


}
