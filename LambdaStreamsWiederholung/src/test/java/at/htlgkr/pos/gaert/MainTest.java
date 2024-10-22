package at.htlgkr.pos.gaert;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void sum() {
        int i = 0;
        int j = 2;
        int expected = 2;
        int result = Main.sum(0, 2);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void emptyString() {
        String s = "";
        boolean expected = true;
        boolean result = Main.emptyString(s);
        assertEquals(expected, result);
    }

    @Test
    void listToUpperCase() {
        List<String> s = List.of(new String[]{"Hallo", "Hi"});
        List<String> expected = List.of(new String[]{"HALLO", "HI"});
        List<String> result = Main.listToUpperCase(s);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void listToLowerCase() {
        List<String> s = List.of(new String[]{"Hallo", "Hi"});
        List<String> expected = List.of(new String[]{"hallo", "hi"});
        List<String> result = Main.listToLowerCase(s);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void evenFilter() {
        List<Integer> s = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = List.of(2, 4, 6, 8, 10);
        List<Integer> result = Main.evenFilter(s);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void oddFilter() {
        List<Integer> s = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = List.of(1, 3, 5, 7, 9);
        List<Integer> result = Main.oddFilter(s);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void sortListLength() {
        List<String> s = List.of(new String[]{"Hallo", "Hi"});
        List<String> expected = new ArrayList<>();
        expected.add("Hi");
        expected.add("Hallo");
        List<String> result = Main.sortListLength(s);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void averageValue() {
        List<Double> list = new ArrayList<>();
        list.add(1.5);
        list.add(1.5);
        double expected = 1.5;
        double result = Main.averageValue(list);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void deleteDuplicates() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        List<Integer> result = Main.deleteDuplicates(list);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getFactorial() {
        int i = 4;
        int expected = 24;
        int result = Main.getFactorial(i);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
        int i = 3;
        boolean expected = true;
        boolean result = Main.isPrime(i);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void concatenateStrings() {
        String s1 = "Hallo";
        String s2 = "Welt";
        String expected = "Hallo Welt";
        String result = Main.concatenateStrings(s1, s2);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getMin() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int expected = 1;
        int result = Main.getMin(list);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getMax() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int expected = 2;
        int result = Main.getMax(list);
        assertEquals(expected, result);
    }

    @Test
    void getProduct() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int e = 6;
        int r = Main.getProduct(list);
        assertEquals(e, r);
    }

    @Test
    void getSum() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int e = 6;
        int r = Main.getSum(list);
        assertEquals(e, r);
    }

    @Test
    void getWordCount() {
        String s = "Dieser Satz hat fünf Wörter!";
        int e = 5;
        int r = Main.getWordCount(s);
        assertEquals(e, r);
    }

    @Test
    void checkPalindrom() {
        String s = "Reliefpfeiler";
        boolean e = true;
        boolean r = Main.checkPalindrom(s);
        assertEquals(e, r);
    }

    @Test
    void getSumSquaresOdd() {
        List<Integer> s = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int e = 220;
        int r = Main.getSumSquaresOdd(s);
        assertEquals(e, r);
    }

    @Test
    void getSumSquaresEven() {
        List<Integer> s = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int e = 165;
        int r = Main.getSumSquaresEven(s);
        assertEquals(e, r);
    }

    @Test
    void checkStringList() {
        List<String> s = List.of(new String[]{"Hallo", "Hi"});
        boolean e = true;
        boolean r = Main.checkStringList(s,"Hallo");
        assertEquals(e, r);
    }

    @Test
    void getLongestString() {
        List<String> s = List.of(new String[]{"Hallo", "Hi", "halb"});
        int e = 5;
        int r = Main.getLongestString(s);
        assertEquals(e, r);
    }

    @Test
    void getShortestString() {
        List<String> s = List.of(new String[]{"Hallo", "halb", "Hi"});
        int e = 2;
        int r = Main.getShortestString(s);
        assertEquals(e, r);
    }

    @Test
    void isPerfectSquare() {
        int i = 4;
        boolean e = true;
        boolean r = Main.isPerfectSquare(i);
        assertEquals(e, r);
    }

    @Test
    void findSecondSmallest() {
        int[] arr = {4, 6, 2, 3, 5, 1};
        int e = 2;
        int r = Main.findSecondSmallest(arr);
        assertEquals(e, r);
    }

    @Test
    void findSecondLargest() {
        int[] arr = {4, 6, 2, 3, 5, 1};
        int e = 5;
        int r = Main.findSecondLargest(arr);
        assertEquals(e, r);
    }

    @Test
    void sortListWithAttributes() {
        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Hi");
        List<String> expected = new ArrayList<>();
        expected.add("Hi");
        expected.add("Hallo");
        List<String> r = Main.sortListWithAttributes(list, value -> {
            value = value.stream().sorted((a, b) -> b.length() - a.length()).toList();
            return value;
        });
        assertEquals(expected, r);
    }

    @Test
    void sumPrimes() {
        int e = 17;
        int r = Main.sumPrimes(10);
        assertEquals(e, r);
    }

    @Test
    void allUpperCase() {
        List<String> list = new ArrayList<>();
        list.add("HALLO");
        list.add("HI");
        boolean e = true;
        boolean r = Main.allUpperCase(list);
        assertEquals(e, r);
    }

    @Test
    void allLowerCase() {
        List<String> list = new ArrayList<>();
        list.add("hallo");
        list.add("hi");
        boolean e = true;
        boolean r = Main.allLowerCase(list);
        assertEquals(e, r);
    }

    @Test
    void checkMixedCase() {
        List<String> list = new ArrayList<>();
        list.add("HALLO");
        list.add("hi");
        boolean e = true;
        boolean r = Main.checkMixedCase(list);
        assertEquals(e, r);
    }

    @Test
    void averageStringLength() {
        List<String> list = new ArrayList<>();
        list.add("HALLO");
        list.add("hi");
        double e = 3.5;
        double r = Main.averageStringLength(list);
    }

    @Test
    void toBinary() {
        int i = 1;
        String e = "1";
        String r = Main.toBinary(i);
        assertEquals(e, r);
    }
}