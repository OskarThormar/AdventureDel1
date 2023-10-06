public class Weapon extends Item{
    protected int damage;
    protected String type;

    public Weapon(String name, String description, int damage, String type) {
        super(name, description);
        this.damage = damage;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", type='" + type + '\'' +
                '}';
    }
}
