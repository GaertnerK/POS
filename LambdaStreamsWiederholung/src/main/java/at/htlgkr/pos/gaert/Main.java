package at.htlgkr.pos.gaert;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(6));
    }

    public static int sum(int i, int j){
        CalcInterface sumInteger = (a, b) -> a + b;
        return sumInteger.calc(i, j);
    }

    public static boolean emptyString(String str){
        EmptyString emptyString = (a) -> a.isEmpty();
        return emptyString.empty(str);
    }

    public static List<String> listToUpperCase(List<String> list){
        StringInterface toUpperCase = (a) -> a.toUpperCase();
        list.forEach(s -> toUpperCase.convert(s));
        return list;
    }

    public static List<String> listToLowerCase(List<String> list){
        StringInterface toLowerCase = (a) -> a.toLowerCase();
        list.forEach(s -> toLowerCase.convert(s));
        return list;
    }

    public static List<Integer> evenFilter(List<Integer> list){
        return list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
    }

    public static List<Integer> oddFilter(List<Integer> list){
        return list.stream().filter(value -> value % 2 != 0).collect(Collectors.toList());
    }

    public static List<String> sortListLength(List<String> list){
        list.sort((a, b) -> b.length() - a.length());
        return list;
    }

    public static Double averageValue(List<Double> list){
        return list.stream().mapToDouble(Double::valueOf).average().getAsDouble() / list.size();
    }

    public static List<Integer> deleteDuplicates(List<Integer> list){
        return new HashSet<>(list).stream().toList();
    }

    public static int getFactorial(int a){
        FactorialInterface factorial = (b) -> {
            int sum = 1;
            for (int i = a; i > 0; i--){
                sum *= i;
            }
            return sum;
        };
        return factorial.getFactorial(a);
    }

    public static boolean isPrime(int a){
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

    public static String concatenateStrings(String s, String s2){
        ConcatenateInterface concatenateInterface = (a, b) -> a + " " + b;
        return concatenateInterface.concatenate(s, s2);
    }

    public static List<Integer> getMin(List<Integer> list){
        list = list.stream().min((a, b) -> b - a).stream().toList();
        return list;
    }

    public static List<Integer> getMax(List<Integer> list){
        list = list.stream().max((a, b) -> b - a).stream().toList();
        return list;
    }


}