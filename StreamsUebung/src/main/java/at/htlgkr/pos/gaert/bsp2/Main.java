package at.htlgkr.pos.gaert.bsp2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(100) + 1;
        }
    }
}
