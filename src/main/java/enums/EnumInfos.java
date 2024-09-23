package enums;

import java.util.Arrays;

import static enums.CarType.GASOLINE;
import static enums.CarType.valueOf;

public class EnumInfos {

    // if we need to create variable/field/method parameter that should take only one of several predefined values
    // we can use enum - e.g. sort of credit card: CREDIT, DEBIT
    //enums work like classes,we can create method arguments class fields,variables of enum type.As value we can pass only one of values defined in it or null

    public static void main(String[] args) {

        refuel(CarType.LPG);
        refuel(CarType.DIESEL);
    }

    public static void refuel(CarType carType) {
        switch (carType) {
            case GASOLINE -> {
                System.out.println("We refuel gasoline");
            }
            case LPG -> {
                System.out.println("We refuel LPG");
            }
            case DIESEL -> {
                System.out.println("We refuel diesel");
            }
            default -> {
                System.out.println("There is no such type of fuel!");
            }
        }

        //Enums should be used when we are certain that a set of values will not change or will change very rarely
        //e.g. of enums ->  role: enum (USER, ADMIN, MODERATOR) / maritalStatus: enum (MARRIED,SINGLE)

        //useful methods:
        //values() - returns all available values of enum as an array
        CarType[] values = CarType.values();
        System.out.println(Arrays.toString(values)); //to print that array we have to use Arrays.toString() method

        //valueOf(String text) - parses an enum from String,returns a value of the given enum type based on the passed string(case is important!)
        CarType lpg = valueOf("LPG");
        System.out.println(lpg);

        //analogously to classes enums can have fields, constructors and methods
        //if we end the list of available values with a semicolon ; then we can define the same elements as in a regular class
        //The only new thing is the way of using constructors - they are called when defining values -> examples package chest


    }

}
