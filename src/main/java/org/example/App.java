package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Map<String, Name> myMap = new HashMap<String, Name>();
        myMap.put("1", new Name("Anand", "Mourya"));
        myMap.put("2", new Name("Vassavi", "Sindhura"));
        myMap.put("3", new Name("Murali", "Krishna"));

        Name found =myMap.entrySet().stream().filter(entry->entry.getKey().equals("7")).findFirst().get().getValue();
        System.out.println(found);

    }
}

class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
