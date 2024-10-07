package at.htlgkr.pos.gaert.bsp3;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isPositive = i -> i > 0;
        Predicate<Integer> isZero = i -> i == 0;
        Predicate<String> isShortWord = s -> s.length() < 4;

        int i = 10;
        isEven.test(i);
        isPositive.test(i);
        isZero.test(i);
        isShortWord.test("abc");

        int j = 0;
        isEven.and(isPositive).test(j);
        isEven.and(isZero).test(j);

    }
}
