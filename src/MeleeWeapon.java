public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, String indexName, String description, int damage, String type) {
        super(name, indexName, description, damage, type);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\uD83E\uDD1C ");
        stringBuilder.append(name);
        stringBuilder.append(" \u2022 ");
        stringBuilder.append(description);
        stringBuilder.append(" \u2022  deals ");
        stringBuilder.append(damage);
        stringBuilder.append(" damage");
        return stringBuilder.toString();
    }
}
