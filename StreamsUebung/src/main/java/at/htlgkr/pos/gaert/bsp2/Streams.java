package at.htlgkr.pos.gaert.bsp2;

import at.htlgkr.pos.gaert.bsp2.Weapon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        double average = 0;
        average = Arrays.stream(numbers).average().getAsDouble();
        return average;
    }
    
    public List<String> upperCase(String[] strings) {
        //implement this
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}