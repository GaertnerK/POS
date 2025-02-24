package weapons;

public final class Wand extends Weapon{

    private String name;

    public Wand() {
        super(15, 0.5);
        this.name = "Zauberstab";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return name + "\n   Damage: " + super.getDamage() + "; Sie können nur bei jedem Angriff zweimal angreifen.";
    }
}
