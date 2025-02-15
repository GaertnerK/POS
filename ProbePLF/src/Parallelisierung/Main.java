package parallelisierung;

public class Main {
    public static void main(String[] args) {
        WeaponsGenerator weapon = new WeaponsGenerator();
        weapon.generateWeapons(6);
        System.out.println();
        weapon.generateWeaponsParallel(13, 10);
    }
}