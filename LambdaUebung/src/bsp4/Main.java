package bsp4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RationalCalculator rc = new RationalCalculator((a, b) -> new Number(a.getA() * b.getA() + a.getB() * b.getB(), a.getB() * b.getB()),
                (a, b) -> new Number(a.getA() * b.getA() - a.getB() * b.getB(), a.getB() - b.getB()),
                (a, b) -> new Number(a.getA() * b.getA(), a.getB() * b.getB()),
                (a, b) -> new Number(a.getA() / b.getA(), a.getB() / b.getB()));

        VectorCalculation vc = new VectorCalculation((a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB()),
                (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB()),
                (a, b) -> new Number(a.getA() * b.getB() - a.getB() * b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA() + a.getB() * b.getB(), 0));

        ComplexCalculation cc = new ComplexCalculation((a, b) -> new Number(a.getA() + b.getA(), 0),
                (a, b) -> new Number(a.getA() - b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA() - a.getB() * b.getB(),
                        a.getA() * b.getB() + a.getB() * b.getA()),
                (a, b) -> new Number((a.getA() * b.getA() + a.getB() * b.getB()) / b.getA() * b.getA() + b.getB() * b.getB(), (a.getB() * b.getA() - a.getA() * b.getB()) / b.getA() * b.getA() + b.getB() * b.getB()));
        boolean loop1 = true;
        while (loop1) {
            System.out.println("Choose calculator:\n" +
                    "1 = Relational calculator\n" +
                    "2 = Vector calculator\n" +
                    "3 = Complex calculator\n" +
                    "4 = Exit program");
            int choice1 = sc.nextInt();
            if (choice1 == 4) {
                break;
            }
            boolean loop2 = true;
            while (loop2) {
                System.out.println("Enter number x a>\n");
                int xA = sc.nextInt();
                System.out.println("Enter number x b>\n");
                int xB = sc.nextInt();
                System.out.println("Enter number y a>\n");
                int yA = sc.nextInt();
                System.out.println("Enter number y b>\n");
                int yB = sc.nextInt();

                Number a = new Number(xA, xB);
                Number b = new Number(yA, yB);

                System.out.println("Choose operation:\n" +
                        "1 = add\n" +
                        "2 = subtract\n" +
                        "3 = multiply\n" +
                        "4 = divide\n" +
                        "5 = enter numbers again");
                int choice2 = sc.nextInt();

                switch (choice1) {
                    case 1:
                        switch (choice2) {
                            case 1:
                                Number solutionAdd = rc.add(a, b);
                                System.out.println(solutionAdd.getA() + " " + solutionAdd.getB());
                                loop2 = false;
                                break;
                            case 2:
                                Number solutionSub = rc.subtract(a, b);
                                System.out.println(solutionSub.getA() + " " + solutionSub.getB());
                                loop2 = false;
                                break;
                            case 3:
                                Number solutionMul = rc.multiply(a, b);
                                System.out.println(solutionMul.getA() + " " + solutionMul.getB());
                                loop2 = false;
                                break;
                            case 4:
                                Number solutionDiv = rc.divide(a, b);
                                System.out.println(solutionDiv.getA() + " " + solutionDiv.getB());
                                loop2 = false;
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        switch (choice2) {
                            case 1:
                                Number solutionAdd = vc.add(a, b);
                                System.out.println(solutionAdd.getA() + " " + solutionAdd.getB());
                                loop2 = false;
                                break;
                            case 2:
                                Number solutionSub = vc.subtract(a, b);
                                System.out.println(solutionSub.getA() + " " + solutionSub.getB());
                                loop2 = false;
                                break;
                            case 3:
                                Number solutionMul = vc.multiply(a, b);
                                System.out.println(solutionMul.getA() + " " + solutionMul.getB());
                                loop2 = false;
                                break;
                            case 4:
                                Number solutionDiv = vc.divide(a, b);
                                System.out.println(solutionDiv.getA() + " " + solutionDiv.getB());
                                loop2 = false;
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        switch (choice2) {
                            case 1:
                                Number solutionAdd = cc.add(a, b);
                                System.out.println(solutionAdd.getA() + " " + solutionAdd.getB());
                                loop2 = false;
                                break;
                            case 2:
                                Number solutionSub = cc.subtract(a, b);
                                System.out.println(solutionSub.getA() + " " + solutionSub.getB());
                                loop2 = false;
                                break;
                            case 3:
                                Number solutionMul = cc.multiply(a, b);
                                System.out.println(solutionMul.getA() + " " + solutionMul.getB());
                                loop2 = false;
                                break;
                            case 4:
                                Number solutionDiv = cc.divide(a, b);
                                System.out.println(solutionDiv.getA() + " " + solutionDiv.getB());
                                loop2 = false;
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
