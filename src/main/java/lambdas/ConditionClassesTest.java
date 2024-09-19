package lambdas;

public class ConditionClassesTest {

    //Lambdas allow to pass behavior in a method parameter
    //e.g. when we want check some confition for given number
    //we can now create NumberCondition interface with the boolean method checkCondition(int number) and implements classes for different conditions
    //LessThan50Condition and EvenCondition with appropriate implementations of the checkCondition method and pass objects of these classes to the method

    public static void main(String[] args) {
        printNumbers(new EvenCondition());
        printNumbers(new LessThan50Condition());

        //Anonymous class
        //we can simplify this by using an anonymous class - class that is defined directly when it is used
        //so instead of creating a separate file with the class, we can define it directly in our method

        //lambda is syntactic sugar / shorthand for an anonymous class that implements an interface with one method (so called @FunctionalInterface)
        //Syntactic sugar - term describing a language instruction that does not introduce new functionalities but simplified existing ones

        //we define conditions with lambda in that way:
        System.out.println("Lambda for x < 45");
        printNumbers(x -> x < 45);
        System.out.println("Lambda for un-even numbers");
        printNumbers(x -> !(x % 2 == 0));

        //Method Reference
        //In addition to lambdas, there is another notation known as method reference with signature CLASS_NAME::METHOD_NAME

        //Notation with lambda
        printNumbers(x -> isNumberEven(x));

        //Notation with lambda reference
        printNumbers(ConditionClassesTest::isNumberEven);

    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

    public static void printNumbers(NumberCondition numberCondition) { //we put here object of choosen class
        for (int i = 40; i <= 60; i++) {
            if (numberCondition.checkCondition(i)) { //and excuted given implementation od checkCondition(), if condition returned true, we printed "i"
                System.out.println(i);
            }
        }
    }
}
