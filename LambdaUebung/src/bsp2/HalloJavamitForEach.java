package bsp2;

import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Java");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

        list.forEach((String s) -> System.out.println(s));
        System.out.println();

        list.forEach(System.out::println);
    }
}
