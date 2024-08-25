package exceptions;

public class ExceptionTest {
    public static void main(String[] args) throws ToSmallValueException, TooBigValueException {
    checkValue(5);
//    checkValue(105);
    checkValue(-5);

    }

    // if we don't want to handle exception we can add 'throw + exception' to signature of method
    public static void checkValue (int value) throws ToSmallValueException, TooBigValueException {
        if(value>100){
            throw new TooBigValueException ("That value is too big");
        }
        else if(value<0){
            throw new ToSmallValueException("That value is too small");
        }
        System.out.println("That value is ok");
    }
}
