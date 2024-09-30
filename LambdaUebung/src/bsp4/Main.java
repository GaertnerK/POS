package bsp4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RationalCalculator rc = new RationalCalculator((a, b) -> new Number(a.getA() + b.getA(), 0),
                (a, b) -> new Number(a.getA() - b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA(), 0),
                (a, b) -> new Number(a.getA() / b.getA(), 0));

        VectorCalculation vc = new VectorCalculation((a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB()),
                (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB()),
                (a, b) -> new Number(a.getA() * b.getB() - a.getB() * b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA() + a.getB() * b.getB(), 0));

        ComplexCalculation cc = new ComplexCalculation((a, b) -> new Number(a.getA() + b.getA(), 0),
                (a, b) -> new Number(a.getA() - b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA() - a.getB() * b.getB(),
                        a.getA() * b.getB() + a.getB() * b.getA()),
                (a, b) -> new Number((a.getA() * b.getA() + a.getB() * b.getB()) / b.getA() * b.getA() + b.getB() * b.getB(), (a.getB() * b.getA() - a.getA() * b.getB()) / b.getA() * b.getA() + b.getB() * b.getB()));

        System.out.println("Choose calculator:\n" +
                "1 = Relationalcalculator\n" +
                "2 = Vector calculator\n" +
                "3 = Complex calculator\n" +
                "4 = Exit program");
        int choice1 = sc.nextInt();
    }
}
