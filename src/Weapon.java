public class Weapon extends Item{
    protected int damage;
    protected String type;

    public Weapon(String name, String description, int damage, String type) {
        super(name, description);
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
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String toString() {
        return name + "damage: " + damage +
                ", type: " + type;
    }
}
