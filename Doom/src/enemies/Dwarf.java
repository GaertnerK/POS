package enemies;

import weapons.Axe;
import weapons.Weapon;

public final class Dwarf extends Enemy{
    private String name;
    private Axe axe;
    public Dwarf(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        this.name = "Zwerg";
        this.axe = new Axe();
    }

    public String getName() {
        return name;
    }

    @Override
    public Axe getWeapon() {
        return axe;
    }

    @Override
    public String getDetails() {
        return this.name + "\n  Leben: " + super.getHealth() + "; Waffe: " + this.axe.getName();
    }
}
