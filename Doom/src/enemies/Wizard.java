package enemies;

import weapons.Wand;

public final class Wizard extends Enemy{
    private String name;
    private Wand wand;
    public Wizard(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        this.name = "Zauberer";
        this.wand = new Wand();
    }

    public String getName() {
        return name;
    }

    @Override
    public Wand getWeapon() {
        return wand;
    }

    @Override
    public String getDetails() {
        return this.name + "\n  Leben: " + super.getHealth() + "; Waffe: " + this.wand.getName();
    }
}


