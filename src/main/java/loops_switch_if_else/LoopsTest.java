package loops_switch_if_else;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoopsTest {
    public static void main(String[] args) {

        //if else - instruction
        System.out.println("Insert your number:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i % 2 == 0) {
            System.out.println("Your number is even");
        } else {
            System.out.println("Your number is not even");
        }

        //else if - instruction
        //used when we want to choose one of the exclusive options
        //The else-if construct does not perform further condition checks if one has been met
        double a = 4;
        double c = 5;
        double b;
        if (a <= 0 || c <= 0) {
            System.out.println("First and second lenght should be bigger then zero");
        } else if (a >= c) {
            System.out.println("Incorrect data");
        } else if (a < c) {
            b = Math.sqrt(c * c - a * a);
            System.out.println("Lenght of b side is: " + b + " cm");
        } else {
            System.out.println("You do not insert proper data");
        }

        //switch-case
        //it is very important to add 'break' in old switch-case because if we forgot to do this, the switch  would execute all cases from the matched one.

        System.out.println("Insert first number: ");
        Scanner scanner1 = new Scanner(System.in);
        int firstNumber = scanner1.nextInt();
        System.out.println("Insert second number");
        Scanner scanner2 = new Scanner(System.in);
        int secondNumber = scanner2.nextInt();

        System.out.println("Insert code of operation: 1-add , 2-substrat, 3-multiply, 4-divide");
        int sign = scanner1.nextInt();

        switch (sign) {
            case 1:
                System.out.println(firstNumber + secondNumber);
                break;
            case 2:
                System.out.println(firstNumber - secondNumber);
                break;
            case 3:
                System.out.println(firstNumber * secondNumber);
            case 4:
                System.out.println(firstNumber / secondNumber);
            default:
                System.out.println("You insert incorrect code of operation!");
        }

        //for each
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("Ania");
        listOfWords.add("Tomasz");
        listOfWords.add("Zofia");

        for (String word : listOfWords) {
            System.out.println(word.toUpperCase());
        }


        //Loops is mechanism that allows you to "loop" the code, i.e. execute its fragment a specified number of times

        //while
        //we execute a given code fragment until the loop condition is met

        int counter = 0;
        while (counter <5) {
            System.out.println("Hallo world!");
            counter ++;
        }

        //for loop - it is shorter while
        for(i=0; i<5; i++){
            System.out.println("Hallo world!");
        }
    }


}
