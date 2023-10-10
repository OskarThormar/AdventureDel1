public class RangedWeapon extends Weapon{
    public int arrows;

    public RangedWeapon(String name, String description, int damage, String type, int arrows) {
        super(name, description, damage, type);
        this.arrows = arrows;
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
