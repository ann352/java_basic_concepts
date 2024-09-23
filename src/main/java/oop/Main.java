package oop;

public class Main {

    //oop - object oriented programming
    //class - it is a definition of new type of Data
    //by fields we define features of object, and by methods its behaviour
    //pattern of method -> [modifier] returned_type methodsName (parameters) { body of method }
    //void - is type of method ,where we make some operation, bu we don't return any results
    //if we do not specify our constuctor, java create default constructor without parameters
    //name of methods should be created as if we were giving an order to be executed

    public static void main(String[] args) {
        Car mazda = new Car("Mazda", 50, 280);
        mazda.refuel(100);
        System.out.println(mazda.getFuel());
    }

    //methods in methods
    //when we use in a few places the same code ,is good to put that in one method - later we change code in only one place, not in many


}
