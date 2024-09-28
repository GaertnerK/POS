package bsp3;

public class Main {
    public static void main(String[] args) {
        NumberTester tester = new NumberTester("testfile.txt");
        tester.setOddTester(n -> n % 2 == 0);

        tester.setPalindromTester(n -> {
            String[] s = String.valueOf(n).split("");
            if (s.length % 2 != 0) {
                return false;
            }
            int counter = s.length-1;
            for (int i = 0; i < s.length/2; i++){
                if (!s[i].equals(s[counter])){
                    return false;
                }
                counter--;
            }
            return true;
        });

        tester.setPrimeTester(n -> {
            if (n <= 2){
                return false;
            }
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        });
        tester.testFile();
    }
}