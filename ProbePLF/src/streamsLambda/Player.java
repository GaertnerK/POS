package streamsLambda;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private double weight;
    private double carrying;
    private List<Weapon> weaponList;

    public Player(String name, double weight, double carrying, List<Weapon> weaponList) {
        this.name = name;
        this.weight = weight;
        this.carrying = carrying;
        this.weaponList = weaponList;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getCarrying() {
        return carrying;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public List<Weapon> findWhereItemIDStartsWith(String idStart){
        return weaponList.stream().filter(s -> s.getItemId().startsWith(idStart)).collect(Collectors.toList());
    }

    public Weapon findWithItemId(String id) {
        return weaponList.stream().filter(w -> w.getItemId().equals(id)).toList().getFirst();
    }

    public void removeDuplicates(){
        weaponList = weaponList.stream().distinct().collect(Collectors.toList());
    }

    public int sumPrice(){
        AtomicInteger price = new AtomicInteger();
        weaponList.forEach(w -> price.addAndGet(w.getPrice()));
        return price.get();
    }

    public int averageAttackPoints(){
        AtomicInteger i = new AtomicInteger();
        weaponList.forEach(w -> {
            i.addAndGet(w.getAttackPoints());
        });
        return i.get() / weaponList.size();
    }

    public Weapon findMostAttackPoints(){
        return weaponList.stream().max(Comparator.comparingInt(Weapon::getAttackPoints)).get();
    }

    public void findWeightOver(){
        //Was soll die Methode machen?
    }

    public List<Weapon> carryAbleWeapons(List<Weapon> list){
        return list.stream().filter(weapon -> (getCarrying()+weapon.getWeight()) < getWeight()).toList();
    }

    @Override
    public String toString() {
        PlayerString playerString = p -> {
            String s = p.name + ": Weight:" + p.weight + "; Carrying:" + p.carrying;
            for (Weapon weapon : weaponList){
                s += weapon.toString() + "\n";
            }
            return s;
        };
        return playerString.playerToString(this);
    }
}
