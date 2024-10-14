import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private double maxWeight;
    private double carrying;
    private List<Weapon> weapons;

    public Player(String name, double maxWeight) {
        this.carrying = 0;
        this.maxWeight = maxWeight;
        this.name = name;
        this.weapons = new ArrayList<>();
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
}
