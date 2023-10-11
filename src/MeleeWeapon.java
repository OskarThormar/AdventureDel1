public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, String description, int damage, String type) {
        super(name, description, damage, type);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" - ");
        stringBuilder.append(description);
        stringBuilder.append(", ");
        stringBuilder.append(damage);
        stringBuilder.append(" damage");
        return stringBuilder.toString();
    }
}
