public class Weapon {
    private String name;
    private int attackPoints;
    private String category;
    private double weight;
    private int price;
    private String itemId;

    public Weapon(String name, int attackPoints, String category, double weight, int price, String itemId) {
        this.attackPoints = attackPoints;
        this.category = category;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "attackPoints=" + attackPoints +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
