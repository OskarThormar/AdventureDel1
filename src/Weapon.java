public class Weapon extends Item{
    protected int damage;
    protected String type;

    public Weapon(String name, String indexName, String description, int damage, String type) {
        super(name, indexName, description);
        this.damage = damage;
        this.type = type;
    }

    public int getDamage(){
        return damage;
    }
    public String getType(){
        return type;
    }

    @Override
    public String getCurrentWeaponType() {
        return super.getCurrentWeaponType();
    }

    @Override
    public int getCurrentWeaponDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }


    @Override
    public String toString() {
        return name + "damage: " + damage +
                ", type: " + type;
    }
}
