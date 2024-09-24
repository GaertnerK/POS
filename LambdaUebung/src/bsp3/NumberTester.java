package bsp3;

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

    }
}
