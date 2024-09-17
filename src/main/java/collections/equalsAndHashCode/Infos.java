package collections.equalsAndHashCode;

public class Infos {
    //variables are creating on stack, and objects are gathering on heap
    //addresses of objects on heap (each object has own address), are assigned to variables on stack
    //for this reason many variables can point to one address
    //Object type variables store addresses of objects but variables of simple types store values
    //to methods as parameter we pass only value of variable,  if we want to get that value , we should use 'return'
    //by '==' we check if variable point at the same object, not if two abjects have the same paramteres

    //equals()
    //method from Object class - to compare one object with another
    //the method returns a boolean value - true if the compared objects are identical, false - if their fields are equal
    // we define what does it mean if objects are equal by overridnig method

    public static void main(String[] args) {
        Person person = new Person("Megan", "Smith", 920401323);
        Person person1 = new Person("Megan Ann", "Smith Moro", 920401323);

        System.out.println(person.equals(person1));

        //hashCode()
        //method from Object class - number representation of object
        //that speeding up, e.g. searching for objects. Based on it libraries, e.g. HashSet, HashMap can create something like a table of contents to speed search for objects

        int i = person.hashCode();
        int i1 = person1.hashCode();

        System.out.println(i = i1); //objects are the same
    }
}

