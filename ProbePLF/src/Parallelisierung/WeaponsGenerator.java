package parallelisierung;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class WeaponsGenerator implements IWeapon{

    private List<Weapon> weaponList;

    public static final List<String> weaponsNames = List.of(new String[]{"Blade of Woe", "Bloodthorn", "Dawnbreaker", "Dwarven", "Orcish", "Glass", "Glass Warhammer", "Elven Battleaxe", "Dwarven Bow", "Orcish Bow"});
    public static final List<String> weaponsCategory = List.of(new String[]{"a", "b", "c", "d", "e", "f"});
    public static final List<String> weaponsItemId = List.of(new String[]{"A", "B", "C", "D", "E", "F"});
    public static final List<String> weaponsDescription = List.of(new String[]{"abc", "def", "ghi", "jkl", "mno", "pqr", "tuv", "wxyz"});

    public WeaponsGenerator() {
        weaponList = new ArrayList<>();
    }

    @Override
    public void generateWeapons(int amount) {
        for (int i = 0; i < amount; i++) {
            Random r = new Random();
            Weapon weapon = new Weapon(weaponsNames.get(r.nextInt(weaponsNames.size())), r.nextInt(100), weaponsCategory.get(r.nextInt(weaponsCategory.size())), r.nextDouble(10), r.nextInt(1000), weaponsItemId.get(r.nextInt(weaponsItemId.size())), weaponsDescription.get(r.nextInt(weaponsDescription.size())));
            weaponList.add(weapon);
        }
        System.out.println(formatWeapons());
    }

    @Override
    public void generateWeaponsParallel(int amount, int amountPerTask) {
        weaponList.clear();
        List<Callable<List<Weapon>>> c = new ArrayList<>();
        for (int i = 0; i < amount / amountPerTask; i++) {
            c.add(new GenerateWeaponCallable(amountPerTask));
         }
        if (amount % amountPerTask != 0){
            int diff = amount % amountPerTask;
            c.add(new GenerateWeaponCallable(diff));
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (Future<List<Weapon>> future : executorService.invokeAll(c)) {
                weaponList.addAll(future.get());
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(formatWeapons());
        System.out.println(weaponList.size());
        executorService.shutdown();
    }

    @Override
    public String formatWeapons() {
        String weaponsString = "";
        for (Weapon weapon : weaponList){
            weaponsString += weapon.toString() + "\n";
        }
        return weaponsString;
    }
}
