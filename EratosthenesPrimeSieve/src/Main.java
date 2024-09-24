import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EratosthenesPrimeSieve eratosthenesPrimeSieve = new EratosthenesPrimeSieve(120);
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number: ");
        int n = in.nextInt();
        boolean isPrime = eratosthenesPrimeSieve.isPrime(n);
        if (isPrime){
            System.out.println("Prime" + "\n");
        }else{
            System.out.println("Not Prime" + "\n");
        }
        eratosthenesPrimeSieve.printPrimes();
    }
}