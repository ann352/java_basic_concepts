package collections.sets;

import java.util.Comparator;

class UserNameComparator implements Comparator<User> {

    //we create here a class which implements Comparator

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
