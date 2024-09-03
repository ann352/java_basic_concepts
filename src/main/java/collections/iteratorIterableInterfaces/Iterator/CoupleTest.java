package collections.iteratorIterableInterfaces.Iterator;

public class CoupleTest {
    public static void main(String[] args) {
        Couple couple1 = new Couple(new Person("Marek"), new Person("Zofia"));
        CoupleIterator coupleIterator = new CoupleIterator(couple1); //we create Iterator here and use its methods

        while (coupleIterator.hasNext()){
            System.out.println(coupleIterator.next());
        }
    }
}
// it is really important to use method hasNext(), when we don't use it properly we can get NoSuchElementException really quick
