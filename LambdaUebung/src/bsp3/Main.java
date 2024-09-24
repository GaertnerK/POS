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
            for (int i = 0; i < s.length/2; i++){
                for (int j = s.length-1; j > s.length/2; j--){
                    if (!s[i].equals(s[j])) {
                        return false;
                    }
                }
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