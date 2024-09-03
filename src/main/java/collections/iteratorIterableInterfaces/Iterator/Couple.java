package collections.iteratorIterableInterfaces.Iterator;

import java.util.Iterator;

public class Couple implements Iterable<Person> { //if we, additionally, add to our class Iterable interface it returns its Iterator

    Person firstPerson, secondPerson;

    public Couple(Person firstPerson, Person secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
    }

    @Override
    public Iterator<Person> iterator() {
        return new CoupleIterator(this);
    }
}
