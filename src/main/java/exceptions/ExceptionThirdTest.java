package exceptions;

public class ExceptionThirdTest {

    //method can throw different exceptions - we add them to the signature of method by use of coma
    public static void main(String[] args) {
        try {
            process(101);
        } catch (ToSmallValueException e) {
            System.out.println("You should insert bigger value");
        } catch (TooBigValueException e) {
            System.out.println("You should insert smaller value ");
        }

        //The method can also throw different exceptions from the same hierarchy, i.e. inheriting from each other.
        //In such a case, the catch blocks should always be in order from the most to the least specific.
        //Every time only one catch block is execute

        try {
            throwExceptionB();
        } catch (ExceptionA e) {
            throw new RuntimeException(e);
        }
        // catch (ExceptionB e) {
        //    System.out.println("Blok catch dla ExceptionB");
        // }
    }

    public static int process(int value) throws ToSmallValueException, TooBigValueException {
        if (value < 0){
            throw new ToSmallValueException("That value is too small!");
        }
        else if (value > 100){
            throw new TooBigValueException("ThatValueIsTooBig");
        }
        return value;
    }

    public static void throwExceptionA() throws ExceptionA {
        throw new ExceptionA();
    }

    public static void throwExceptionB() throws ExceptionB {
        throw new ExceptionB();
    }
}
