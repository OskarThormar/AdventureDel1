public class RangedWeaponAmmo extends RangedWeapon{
    public RangedWeaponAmmo(String name, String description, int damage, String type, int arrows) {
        super(name, description, damage, type, arrows);
    }
    public int getArrows(){
        return arrows;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(arrows);
        stringBuilder.append(" arrows");
        return stringBuilder.toString();
    }
}
