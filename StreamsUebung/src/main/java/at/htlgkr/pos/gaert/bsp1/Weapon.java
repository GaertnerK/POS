package at.htlgkr.pos.gaert.bsp1;

public class Weapon {
    private String name;
    private String combatType;
    private String damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon(String combatType, int damage, String damageType, String name, int speed, int strength, int value) {
        this.combatType = combatType;
        this.damage = damage;
        this.damageType = damageType;
        this.name = name;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public String getCombatType() {
        return combatType;
    }

    public int getDamage() {
        return damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }
}
