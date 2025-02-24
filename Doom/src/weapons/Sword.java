package weapons;

public final class Sword extends Weapon{
    private String name;

    public Sword() {
        super(20, 1.0);
        this.name = "Schwert";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails(){
        return name + "\n   Damage: " + super.getDamage() + "; Sie können nur bei jedem Angriff angreifen.";
    }
}
