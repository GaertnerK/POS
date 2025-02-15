package enemies;

import weapons.Sword;
import weapons.Weapon;

public final class Zombie extends Enemy{
    private String name;
    private Sword sword;

    public Zombie(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        this.name = "Zombie";
        this.sword = new Sword();
    }

    @Override
    public Sword getWeapon() {
        return sword;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return this.name + "\n  Leben: " + super.getHealth() + "; Waffe: " + this.sword.getName();
    }
}
