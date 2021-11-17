package main;

import person.Person;
import сallFunctionAnnotation.UtilitiesForCallFunctionAnnotation;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Anastasia", "Molchanova", "Saint Petersburg", 18);
        UtilitiesForCallFunctionAnnotation.callMethodsMarkedAnnotation(person);
    }
}
