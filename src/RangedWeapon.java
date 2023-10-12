public class RangedWeapon extends Weapon{
    public int arrows;

    public RangedWeapon(String name, String indexName, String description, int damage, String type, int arrows) {
        super(name, indexName, description, damage, type);
        this.arrows = arrows;
    }

    @Override
    public int getCurrentWeaponDamage() {
        return super.getCurrentWeaponDamage();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(description);
        stringBuilder.append(", ");
        stringBuilder.append(damage);
        stringBuilder.append(" damage");
        return stringBuilder.toString();
    }
}
