package collections.sets;

import java.util.Objects;

public class User {

    public String name, surname, email;

    public User(String names, String surname, String email) {
        this.name = names;
        this.surname = surname;
        this.email = email;
    }

    //we generate equals() and hashcode() method, and define them
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "names='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
