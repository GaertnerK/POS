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
}
