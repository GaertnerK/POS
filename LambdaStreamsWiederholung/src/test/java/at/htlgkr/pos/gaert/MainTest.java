package at.htlgkr.pos.gaert;

import org.junit.jupiter.api.Test;

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

    }

    @org.junit.jupiter.api.Test
    void oddFilter() {
    }

    @org.junit.jupiter.api.Test
    void sortListLength() {
    }

    @org.junit.jupiter.api.Test
    void averageValue() {
    }

    @org.junit.jupiter.api.Test
    void deleteDuplicates() {
    }

    @org.junit.jupiter.api.Test
    void getFactorial() {
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
    }

    @org.junit.jupiter.api.Test
    void concatenateStrings() {
    }

    @org.junit.jupiter.api.Test
    void getMin() {
    }

    @org.junit.jupiter.api.Test
    void getMax() {
    }
}