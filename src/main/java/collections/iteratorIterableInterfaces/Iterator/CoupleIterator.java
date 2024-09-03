package collections.iteratorIterableInterfaces.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CoupleIterator implements Iterator<Person> {

    //when class implements Iterator interface, e.g. with generic type Person
    //we have to implement its methods and that class should return CoupleIterator that can iterate over Persons
    //because they are elements of couple

    Couple coupleToIterate;
    int currentPerson = -1; //additional field, when its value is -1 we didn't start checking elements

    public CoupleIterator(Couple coupleToIterate) {
        this.coupleToIterate = coupleToIterate;
    }

    @Override
    public boolean hasNext() { //we check if we have next element to return
        return currentPerson < 1; //here we put expression that could evaluate to true or false
    }

    @Override
    public Person next() { //we point at next element
        currentPerson++; //we increase counter
        if (currentPerson == 0) {
            return coupleToIterate.firstPerson;
        } else if (currentPerson == 1) {
            return coupleToIterate.secondPerson; //we return current element
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() { //we remove current element

        if (currentPerson == 0) { //we check with currentPerson field where are we now
            coupleToIterate.firstPerson = null;
        } else if (currentPerson == 1) {
            coupleToIterate.secondPerson = null;
        } else throw new NoSuchElementException();
    }
}
