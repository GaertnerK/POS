import java.util.ArrayList;
import java.util.List;

public class EratosthenesPrimeSieve implements PrimeSieve{
    private int border;
    private boolean[] numbers;

    public EratosthenesPrimeSieve(int border) {
        this.border = border-2;
    }

    @Override
    public boolean isPrime(int p) {
        numbers = new boolean[border];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = true;
        }
        for (int i = 0; i < numbers.length; i++) {
            int number = i + 2;
            while (number <= border){
                number += (i + 2);
                if (number > border){
                    break;
                }
                numbers[number-2] = false;
            }
        }
        for (int i = 2; i < numbers.length; i++){
            if (i == p){
                return true;
            }
        }
        return false;
    }

    @Override
    public void printPrimes() {
        int counter = 0;
        System.out.println("Primes:");
        for (int i = 2; i < numbers.length; i++){
            if (numbers[i-2] == true){
                System.out.print(i + " ");
                counter++;

            }
            if (counter == 10){
                System.out.println();
                counter = 0;
            }
        }
    }
}
