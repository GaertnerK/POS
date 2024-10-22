package at.htlgkr.pos.gaert;

import at.htlgkr.pos.gaert.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> s = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(getSumSquaresEven(s));
    }

    public static int sum(int i, int j) {
        CalcInterface sumInteger = (a, b) -> a + b;
        return sumInteger.calc(i, j);
    }

    public static boolean emptyString(String str) {
        EmptyString emptyString = (a) -> a.isEmpty();
        return emptyString.empty(str);
    }

    public static List<String> listToUpperCase(List<String> list) {
        StringInterface stringToUpperCase = s -> s.stream().map(String::toUpperCase).toList();
        return stringToUpperCase.convert(list);
    }

    public static List<String> listToLowerCase(List<String> list) {
        StringInterface stringToLowerCase = s -> s.stream().map(String::toLowerCase).toList();
        return stringToLowerCase.convert(list);
    }

    public static List<Integer> evenFilter(List<Integer> list) {
        return list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
    }

    public static List<Integer> oddFilter(List<Integer> list) {
        return list.stream().filter(value -> value % 2 != 0).collect(Collectors.toList());
    }

    public static List<String> sortListLength(List<String> list) {
        list.sort((a, b) -> b.length() - a.length());
        return list;
    }

    public static Double averageValue(List<Double> list) {
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        list.forEach(value -> sum.set(sum.get() + value));
        return sum.get()/list.size();
    }

    public static List<Integer> deleteDuplicates(List<Integer> list) {
        return list.stream().distinct().toList();
    }

    public static int getFactorial(int a) {
        FactorialInterface factorial = (b) -> {
            int sum = 1;
            for (int i = a; i > 0; i--) {
                sum *= i;
            }
            return sum;
        };
        return factorial.getFactorial(a);
    }

    public static boolean isPrime(int a) {
        IsPrimeInterface prime = b -> {
            if (b <= 2) {
                return (b == 2);
            }
            for (long i = 2; i * i <= b; i++) {
                if (b % i == 0) {
                    return false;
                }
            }
            return true;
        };
        return prime.isPrime(a);
    }

    public static String concatenateStrings(String s, String s2) {
        ConcatenateInterface concatenateInterface = (a, b) -> a + " " + b;
        return concatenateInterface.concatenate(s, s2);
    }

    public static int getMin(List<Integer> list) {
        return list.stream().min(Integer::compareTo).get().intValue();
    }

    public static int getMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get().intValue();
    }

    public static int getProduct(List<Integer> list) {
        CalcInterface product = (a, b) -> a * b;
        AtomicInteger i = new AtomicInteger(1);
        list.forEach(a -> i.set(product.calc(i.get(), a)));
        return i.get();
    }

    public static int getSum(List<Integer> list) {
        CalcInterface sum = (a, b) -> a + b;
        AtomicInteger i = new AtomicInteger(0);
        list.forEach(a -> i.set(sum.calc(i.get(), a)));
        return i.get();
    }

    public static int getWordCount(String s) {
        return Arrays.stream(s.split(" ")).toList().size();
    }

    public static boolean checkPalindrom(String s) {
        CheckString palindrom = a -> {
            int counter = a.length() - 1;
            for (int i = 0; i < a.length() / 2; i++) {
                if (a.charAt(i) != a.charAt(counter)) {
                    return false;
                }
                counter--;
            }
            return true;
        };
        return palindrom.checkString(s);
    }

    public static int getSumSquaresOdd(List<Integer> list) {
        SquaresInterface odd = a -> {
            AtomicInteger sum = new AtomicInteger();
            a.forEach(value -> {
                if (value % 2 == 0) {
                    sum.set(sum.get() + (value * value));
                }
            });
            return sum.get();
        };
        return odd.getSquares(list);
    }

    public static int getSumSquaresEven(List<Integer> list) {
        SquaresInterface odd = a -> {
            AtomicInteger sum = new AtomicInteger();
            a.forEach(value -> {
                if (value % 2 != 0) {
                    sum.set(sum.get() + (value * value));
                }
            });
            return sum.get();
        };
        return odd.getSquares(list);
    }

    public static boolean checkStringList(List<String> list, String s) {
        return list.stream().anyMatch(a -> a.contains(s));
    }

    public static int getLongestString(List<String> list) {
        return list.stream().min(String::compareTo).get().length();
    }

    public static int getShortestString(List<String> list) {
        return list.stream().max((a, b) -> b.length() - a.length()).get().length();
    }

    public static boolean isPerfectSquare(int i) {
        CheckIntegerInterface perfectSquare = a -> {
            int sqrt = (int) Math.sqrt(a);
            return sqrt * sqrt == a;
        };
        return perfectSquare.checkInteger(i);
    }

    public static int findSecondSmallest(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        return arr[1];
    }

    public static int findSecondLargest(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        return arr[arr.length - 2];
    }

    public static List<String> sortListWithAttributes(List<String> list, SortStringInterface sortStringInterface) {
        return sortStringInterface.sortStrings(list);
    }

    public static int sumPrimes(int range) {
        AtomicInteger sum = new AtomicInteger();
        IntegerInterface sumPrime = a -> {
            int i = 0;
            while (a >= i) {
                if (isPrime(i)) {
                    sum.addAndGet(i);
                }
                i++;
            }
            return sum.get();
        };
        return sumPrime.getInt(range);
    }

    public static boolean allUpperCase(List<String> list){
        CheckString checkUpperCase = a -> a.toUpperCase().equals(a);
        boolean b = list.stream().map(checkUpperCase::checkString)
                .toList()
                .contains(false);
        return !b;
    }

    public static boolean allLowerCase(List<String> list) {
        CheckString checkLowerCase = a -> a.toLowerCase().equals(a);
        boolean b = list.stream().map(checkLowerCase::checkString)
                .toList()
                .contains(false);
        return !b;
    }

    public static boolean checkMixedCase(List<String> list){
        if (!allUpperCase(list) && !allLowerCase(list)){
            return true;
        }
        return false;
    }

    public static double averageStringLength(List<String> list){
        AtomicInteger sum = new AtomicInteger();
        AverageStringLengthInterface getAverageLength = a -> {
            a.forEach(value -> sum.addAndGet(value.length()));
            return sum.get()/a.size();
        };
       return getAverageLength.getAverage(list);
    }

    public static String toBinary(int i){
        ToBinaryInterface toBinary = a -> Integer.toBinaryString(i);
        return toBinary.getBinary(i);
    }
}