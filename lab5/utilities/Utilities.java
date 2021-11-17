package utilities;

import java.util.*;
import java.util.stream.Collectors;

public class Utilities {

    public static double calculateAverageMean(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<String> changeLineView(List<String> lines) {
        if (lines == null) {
            return null;
        }
        return lines.stream()
                .map(String::toUpperCase)
                .map(line -> "_new_" + line)
                .toList();
    }

    public static List<Double> squareUniqueNumbers(List<Double> numbers) {
        if (numbers == null) {
            return null;
        }
        return numbers.stream()
                .distinct()
                .map(number -> number * number)
                .toList();
    }

    public static List<String> getLinesStartingWithAGivenLetterAndSortAlphabetically(Collection<String> lines, char letter) {
        if (lines == null) {
            return null;
        }
        return lines.stream()
                .filter(line -> line.toLowerCase().charAt(0) == letter)
                .sorted()
                .toList();
    }

    public static <T> T getLastElement(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    public static int getSumOfEvenNumbers(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static Map<Character, String> createMapOfList(List<String> lines) {
        if (lines == null) {
            return null;
        }
        return lines.stream()
                .collect(Collectors.toMap(key -> key.charAt(0), item -> item.substring(1)));
    }
}