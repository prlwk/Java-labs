package person;

import сallFunctionAnnotation.CallFunctionAnnotation;

public class Person {
    private String name;
    private int age;
    private String lastName;
    private String city;

    public Person(String name, String lastName, String city, int age) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.city = city;
    }

    @CallFunctionAnnotation
    private void printAge() {
        System.out.println("Age: " + age);
    }

    @CallFunctionAnnotation(2)
    private void printName() {
        System.out.println("Name: " + name);
    }

    @CallFunctionAnnotation(3)
    private void printLastName() {
        System.out.println("Lastname: " + lastName);
    }

    @CallFunctionAnnotation(4)
    private void printCity() {
        System.out.println("City: " + city);
    }
}
