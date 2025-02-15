package weapons;

public final class Axe extends Weapon{

    private String name;

    public Axe() {
        super(30, 1.5);
        this.name = "Axt";
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return name + "\n   Damage: " + super.getDamage() + "; Sie können nur alle zwei Angriff angreifen.";
    }
}
