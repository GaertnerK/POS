package bsp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    String fileName;
    NumberTest oddTester;
    NumberTest primeTester;
    NumberTest palindromTester;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPalindromTester(NumberTest palindromTester) {
        this.palindromTester = palindromTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void testFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String commandLine = br.readLine();
            int linesCount = Integer.parseInt(commandLine);
            for (int i = 0; i < linesCount; i++) {
                commandLine = br.readLine();
                String[] parts = commandLine.split(" ");
                switch (parts[0]) {
                    case "1":
                        if (oddTester.testNumber(Integer.parseInt(parts[1]))) {
                            System.out.println("EVEN");
                        }else {
                            System.out.println("ODD");
                        }
                        break;
                    case "2":
                        if(primeTester.testNumber(Integer.parseInt(parts[1]))){
                            System.out.println("PRIME");
                        }else {
                            System.out.println("NO PRIME");
                        }
                        break;
                    case "3":
                        if(palindromTester.testNumber(Integer.parseInt(parts[1]))){
                            System.out.println("PALINDROM");
                        }else {
                            System.out.println("NO PALINDROM");
                        }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
