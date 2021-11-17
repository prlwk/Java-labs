package tests;

import utilities.Utilities;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    List<Integer> integerList = new ArrayList<>();
    List<Double> doubleList = new ArrayList<>();
    List<String> lines = new ArrayList<>();

    private void fillIntegerList() {
        integerList.add(4);
        integerList.add(-5);
        integerList.add(0);
        integerList.add(135);
        integerList.add(7);
        integerList.add(7);
    }

    private void fillDoubleList() {
        doubleList.add(4.0);
        doubleList.add(-5.6);
        doubleList.add(0.3);
        doubleList.add(135.0);
        doubleList.add(7.8);
        doubleList.add(7.8);
    }

    private void fillListOfLines() {
        lines.add("Dog");
        lines.add("Hello");
        lines.add("Human");
        lines.add("Hi");
        lines.add("Beautiful");
        lines.add("A");
    }

    @org.junit.jupiter.api.Test
    void calculateAverageMean() {
        assertThrows(NoSuchElementException.class, () -> Utilities.calculateAverageMean(new ArrayList<>()));
        assertThrows(NullPointerException.class, () -> Utilities.calculateAverageMean(null));
        fillIntegerList();
        double sum = 0;
        for (Integer number : integerList) {
            sum += number;
        }
        assertEquals(sum / integerList.size(), Utilities.calculateAverageMean(integerList));
    }

    @org.junit.jupiter.api.Test
    void changeLineView() {
        fillListOfLines();
        List<String> modifiedLines = Utilities.changeLineView(lines);
        for (String line : modifiedLines) {
            assertEquals("_new_", line.substring(0, 5));
        }
        assertNull(Utilities.changeLineView(null));
        List<String> emptyList = Utilities.changeLineView(new ArrayList<>());
        assertTrue(emptyList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void squareUniqueNumbers() {
        fillDoubleList();
        List<Double> squaredUniqueNumbers = Utilities.squareUniqueNumbers(doubleList);
        Set<Double> set = new HashSet<>(doubleList);
        doubleList = new ArrayList<>(set);
        for (int i = 0; i < squaredUniqueNumbers.size(); i++) {
            assertEquals(squaredUniqueNumbers.get(i), doubleList.get(i) * doubleList.get(i));
            for (int j = i + 1; j < squaredUniqueNumbers.size(); j++) {
                assertNotSame(squaredUniqueNumbers.get(i), squaredUniqueNumbers.get(j));
            }
        }
        assertEquals(doubleList.size(), squaredUniqueNumbers.size());
    }

    @org.junit.jupiter.api.Test
    void getLinesStartingWithAGivenLetterAndSortAlphabetically() {
        fillListOfLines();
        List<String> modifiedLines = Utilities.getLinesStartingWithAGivenLetterAndSortAlphabetically(lines, 'h');
        for (String line : modifiedLines) {
            assertEquals("h", line.substring(0, 1).toLowerCase());
        }
        for (int i = 1; i < modifiedLines.size(); i++) {
            if (modifiedLines.get(i - 1).length() > 1 && modifiedLines.get(i).length() > 1) {
                assertTrue(modifiedLines.get(i - 1).charAt(1) <= modifiedLines.get(i).charAt(1));
            }
        }
        assertNull(Utilities.getLinesStartingWithAGivenLetterAndSortAlphabetically(null, 'a'));
        List<String> emptyList = Utilities.getLinesStartingWithAGivenLetterAndSortAlphabetically(new ArrayList<>(), 'a');
        assertTrue(emptyList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getLastElement() {
        fillListOfLines();
        String lastLine = Utilities.getLastElement(lines);
        assertEquals(lastLine, lines.get(lines.size() - 1));

        fillDoubleList();
        double lastDoubleNumber = Utilities.getLastElement(doubleList);
        assertEquals(lastDoubleNumber, doubleList.get(doubleList.size() - 1));

        fillIntegerList();
        int lastIntegerNumber = Utilities.getLastElement(integerList);
        assertEquals(lastIntegerNumber, integerList.get(integerList.size() - 1));

        assertThrows(IllegalArgumentException.class, () -> Utilities.getLastElement(null));
        assertThrows(NoSuchElementException.class, () -> Utilities.getLastElement(new ArrayList<String>()));
    }

    @org.junit.jupiter.api.Test
    void getSumOfEvenNumbers() {
        int[] numbers = {0, 4, 7, 9, 8, 6, 9, 1, 2};
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        assertEquals(sum, Utilities.getSumOfEvenNumbers(numbers));

        int[] emptyArray = new int[5];
        assertEquals(0, Utilities.getSumOfEvenNumbers(emptyArray));
        assertThrows(IllegalArgumentException.class, () -> Utilities.getSumOfEvenNumbers(null));
    }

    @org.junit.jupiter.api.Test
    void createMapOfList() {
        fillListOfLines();
        lines.remove("Human");
        lines.remove("Hi");
        Map<Character, String> map = Utilities.createMapOfList(lines);
        for (String line : lines) {
            assertEquals(map.get(line.charAt(0)), line.substring(1));
        }

        assertNull(Utilities.createMapOfList(null));
        assertTrue(Utilities.createMapOfList(new ArrayList<>()).isEmpty());
    }
}
