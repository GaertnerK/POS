package bsp4;

public class Main {
    public static void main(String[] args) {
        RationalCalculator rc = new RationalCalculator((a, b) -> new Number(a.getA() + b.getA(), 0),
                (a, b) -> new Number(a.getA() - b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA(), 0),
                (a, b) -> new Number(a.getA() / b.getA(), 0));
    }
}
