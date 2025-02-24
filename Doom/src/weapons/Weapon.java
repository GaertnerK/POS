package weapons;

public sealed abstract class Weapon permits Axe, Hand, Sword, Wand {
    private int damage;
    private double attackSpeed;

    public Weapon(int damage, double attackSpeed) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public abstract String getName();
    public abstract String getDetails();
}
