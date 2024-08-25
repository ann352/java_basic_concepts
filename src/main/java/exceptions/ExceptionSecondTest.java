package exceptions;

public class ExceptionSecondTest {
    public static void main(String[] args) {

        try {
            divideNumbers(5, 0);
        } catch (IncorrectDivisorException e) { //we catch here our exception
            System.out.println("You are in 'catch' "); //here we put instructions what to do when we have exception
        } finally { //that code that will always be executed, no matters if we have exception or not - e.g. we can close here connection to database or file
            System.out.println("That part is executed always!");
        }

    }

    public static int divideNumbers(int firstValue, int secondValue) throws IncorrectDivisorException {
        if (secondValue == 0) {
            throw new IncorrectDivisorException("You can not divide by zero!");
        }
        return firstValue / secondValue;
    }
}
