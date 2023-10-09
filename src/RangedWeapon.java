public class RangedWeapon extends Weapon{

    public RangedWeapon(String name, String description, int damage, String type) {
        super(name, description, damage, type);
    }

    @Override
    public String toString() {
        return "RangedWeapon{" +
                "damage=" + damage +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
