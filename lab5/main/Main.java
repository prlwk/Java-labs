package main;

import utilities.Utilities;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        workWithUtilitiesForIntegerList();
        workWithUtilitiesForDoubleList();
        workWithUtilitiesForStringList();
    }

    private static void fillIntegerList(List<Integer> integerList) {
        integerList.add(4);
        integerList.add(-5);
        integerList.add(0);
        integerList.add(135);
        integerList.add(7);
        integerList.add(7);
    }

    private static void fillDoubleList(List<Double> doubleList) {
        doubleList.add(4.0);
        doubleList.add(-5.6);
        doubleList.add(0.3);
        doubleList.add(135.0);
        doubleList.add(7.8);
        doubleList.add(7.8);
    }

    private static void fillListOfLines(List<String> lines) {
        lines.add("Dog");
        lines.add("Hello");
        lines.add("Human");
        lines.add("Hi");
        lines.add("Beautiful");
        lines.add("A");
    }

    private static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    private static void workWithUtilitiesForIntegerList() {
        List<Integer> integerList = new ArrayList<>();

        fillIntegerList(integerList);
        System.out.println("List of integers:");
        printList(integerList);

        System.out.println("Average value of list of integers: " + Utilities.calculateAverageMean(integerList));

        int[] numbers = {0, 4, 7, 9, 8, 6, 9, 1, 2};
        System.out.println("Array of integers");
        printList(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
        System.out.println("Sum of even numbers of array of integers: " + Utilities.getSumOfEvenNumbers(numbers));
    }

    private static void workWithUtilitiesForDoubleList() {
        List<Double> doubleList = new ArrayList<>();

        fillDoubleList(doubleList);
        System.out.println("List of doubles:");
        printList(doubleList);

        System.out.println("List of squared unique doubles:");
        printList(Utilities.squareUniqueNumbers(doubleList));

        System.out.println("Last element of doubles: " + Utilities.getLastElement(doubleList));
    }

    private static void workWithUtilitiesForStringList() {
        List<String> lines = new ArrayList<>();

        System.out.println("List of strings:");
        fillListOfLines(lines);
        printList(lines);

        System.out.println("List of strings after changes");
        printList(Utilities.changeLineView(lines));

        System.out.println("Strings that start with a letter H in alphabetical order");
        printList(Utilities.getLinesStartingWithAGivenLetterAndSortAlphabetically(lines, 'h'));

        System.out.println("List of lines to map:");
        lines.remove("Human");
        lines.remove("Hi");
        System.out.println(Utilities.createMapOfList(lines));
    }
}
