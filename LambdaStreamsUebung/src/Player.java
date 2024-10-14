import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Player implements IWeapons{
    private String name;
    private double maxWeight;
    private double carrying;
    private List<Weapon> weapons;

    public Player(String name, double maxWeight, List<Weapon> weapons) {
        this.carrying = 0;
        this.maxWeight = maxWeight;
        this.name = name;
        this.weapons = weapons;
    }

    public double getCarrying() {
        this.carrying += weapons.stream().mapToDouble(Weapon::getWeight).sum();
        return carrying;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    @Override
    public List<Weapon> findWhereItemIDStartsWith(String searchString) {
        return weapons.stream().filter(weapon -> weapon.getItemId().startsWith(searchString)).collect(Collectors.toList());
    }

    @Override
    public Weapon findWithItemID(String itemID) {
        AtomicReference<Weapon> weaponTemp = new AtomicReference<>();
        weapons.forEach(value -> {
            if (value.getItemId().equals(itemID)) {
                weaponTemp.set(value);
            }
        });
        return weaponTemp.get();
    }

    @Override
    public List<Weapon> findWithCategory(String category) {
        return weapons.stream().filter(weapon -> weapon.getCategory().equals(category)).collect(Collectors.toList());
    }

    @Override
    public int sumPrice() {
        AtomicInteger sum = new AtomicInteger();
        weapons.forEach(value -> sum.addAndGet(value.getPrice()));
        return sum.get();
    }

    @Override
    public int averageAttackPoints() {
        List<Integer> attackPoints = new ArrayList<>();
        weapons.forEach(value -> {
            attackPoints.add(value.getAttackPoints());
        });
        AtomicInteger average = new AtomicInteger();
        attackPoints.forEach(value -> average.addAndGet(value));
        int temp = average.get() / weapons.size();
        return temp;
    }

    @Override
    public Weapon findWithMostAttackPoints() {
        int mostAttackPoints = 0;
        AtomicReference<Weapon> weapon = new AtomicReference<>();
        weapons.forEach(value -> {
            if (mostAttackPoints < value.getAttackPoints()){
                weapon.set(value);
            }
        });
        return weapon.get();
    }

    @Override
    public List<Weapon> findWeightUnder(float weight) {
        return weapons.stream().filter(weapon -> weapon.getWeight() < weight).collect(Collectors.toList());
    }

    @Override
    public List<Weapon> carryAbleWeapons(Player player) {
        int carryableWeapons = 0;
        player.weapons.forEach(weapon -> carrying += weapon.getWeight());
        return weapons.stream().filter(weapon -> (carryableWeapons - weapon.getWeight()) < maxWeight).collect(Collectors.toList());
    }
}
