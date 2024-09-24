import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.forEach(System.out::println);

        TextFormatter ask = text -> text + "?";
        TextFormatter shout = text -> text + "!";

        Demo demo = new Demo();
        demo.setFormatter(ask);
        String formatted = demo.format("Was ist das");
    }
}