package weapons;

public final class Hand extends Weapon{
    private String name;
    public Hand() {
        super(10, 1.0);
        name = "Hand";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return name + "\n   Damage: " + super.getDamage() + "; Sie können bei jedem Angriff zweimal angreifen.";
    }
}
