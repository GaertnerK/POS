package parallelisierung;

public interface IWeapon {
    void generateWeapons(int amount);
    void generateWeaponsParallel(int amount, int amountPerTask);
    String formatWeapons();
}