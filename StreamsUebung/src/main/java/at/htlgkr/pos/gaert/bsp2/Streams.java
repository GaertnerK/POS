package at.htlgkr.pos.gaert.bsp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        double average = 0;
        average = Arrays.stream(numbers).average().getAsDouble();
        return average;
    }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).toList();
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        weapons.sort((a, b) -> b.getDamage() - a.getDamage());
        if (weapons.size() >= 1) {
            return weapons.get(weapons.size() - 1);
        }
        return null;
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        weapons.sort((a, b) -> b.getMinStrength() - a.getMinStrength());
        if (weapons.size() >= 1) {
            return weapons.get(0);
        }
        return null;
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(weapon -> weapon.getDamageType().toString().toLowerCase().equals("missile")).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        weapons.sort((a, b) -> b.getName().length() - a.getName().length());
        if (weapons.size() >= 1) {
            return weapons.get(0);
        }
        return null;
    }

    public List<String> toNameList(List<Weapon> weapons) {
        List<String> names = new ArrayList<>();
        weapons.forEach(weapon -> names.add(weapon.getName()));
        return names;
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        int[] speeds = new int[weapons.size()];
        for (int i = 0; i < weapons.size(); i++) {
            speeds[i] = weapons.get(i).getSpeed();
        }
        return speeds;
    }

    public int sumUpValues(List<Weapon> weapons) {
        AtomicInteger sum = new AtomicInteger();
        weapons.forEach(weapon -> sum.addAndGet(weapon.getValue()));
        return sum.get();
    }

    public int sumUpHashCodes(List<Weapon> weapons) {
        AtomicInteger sum = new AtomicInteger();
        weapons.forEach(weapon -> sum.addAndGet((weapon.hashCode())));
        return sum.get();
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       weapons.forEach(weapon -> {
           int i = (int) (weapon.getValue() * 0.1);
           weapon.setValue(i);
       });
    }
}
