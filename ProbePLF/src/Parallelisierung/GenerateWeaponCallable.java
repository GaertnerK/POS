package parallelisierung;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class GenerateWeaponCallable implements Callable<List<Weapon>> {
    private int amount;
    private List<Weapon> weaponList;

    public GenerateWeaponCallable(int amount) {
        this.amount = amount;
        weaponList = new ArrayList<>();
    }

    @Override
    public List<Weapon> call() throws Exception {
        for (int i = 0; i < amount; i++) {
            Random r = new Random();
            Weapon weapon = new Weapon(WeaponsGenerator.weaponsNames.get(r.nextInt(WeaponsGenerator.weaponsNames.size())), r.nextInt(100), WeaponsGenerator.weaponsCategory.get(r.nextInt(WeaponsGenerator.weaponsCategory.size())), r.nextDouble(10), r.nextInt(1000),WeaponsGenerator.weaponsItemId.get(r.nextInt(WeaponsGenerator.weaponsItemId.size())), WeaponsGenerator.weaponsDescription.get(r.nextInt(WeaponsGenerator.weaponsDescription.size())));
            weaponList.add(weapon);
        }
        return weaponList;
    }
}
