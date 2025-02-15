package streamsLambda;

import java.util.List;

public class Weapon {
    private String name;
    private int attackPoints;
    private String category;
    private double weight;
    private int price;
    private String itemId;
    private String description;
    public Weapon(String name, int attackPoints, String category, double weight, int price, String itemId, String description) {
        this.attackPoints = attackPoints;
        this.category = category;
        this.description = description;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  name + ": AP:" + attackPoints + "; Category:" + category + "; Weight:" + weight + "; Price:" + price + "; ItemID:" + itemId + "; Description:" + description;
    }
}
