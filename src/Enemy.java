import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private String enemyDescription;
    private String enemyRoar;
    private ArrayList<Enemy> enemies;
    private ArrayList<Item> enemyItems;

    public Enemy(String enemyName, String enemyDescription, int enemyHealth, int enemyDamage, String enemyRoar) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
        this.enemies = new ArrayList<>();
        this.enemyItems = new ArrayList<>();
        this.enemyRoar = enemyRoar;
    }
   // Item goblinDagger = new MeleeWeapon("Goblin dagger", "Greasy and disgusting, looks dull", 5, "Melee");

    public String getEnemyName(){
        return enemyName;
    }
    public void setEnemyName(String enemyName){
        this.enemyName = enemyName;
    }
    public int getEnemyDamage(){
        return enemyDamage;
    }
    public void setEnemyDamage(int enemyDamage){
        this.enemyDamage = enemyDamage;
    }
    public int getEnemyHealth(){
        return enemyHealth;
    }
    public void setEnemyHealth(int enemyHealth){
        this.enemyHealth = enemyHealth;
    }
    public String getEnemyDescription(){
        return enemyDescription;
    }
    public void setEnemyDescription(){
        this.enemyDescription = enemyDescription;
    }
    public ArrayList<Item> addEnemyItems(Item item) {
        this.enemyItems.add(item);
        return null;
    }
    public Item getEnemyItems(){
        for (Item enemyItem : enemyItems) {
            return enemyItem;
        }

        return null;
    }
    public String getEnemyRoar(){
        return enemyRoar;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enemies found: \n");
        stringBuilder.append(enemyName);
        stringBuilder.append(", ");
        stringBuilder.append(enemyDescription);
        stringBuilder.append(" deals ");
        stringBuilder.append(enemyDamage);
        stringBuilder.append(" damage and has ");
        stringBuilder.append(enemyHealth);
        stringBuilder.append(" health");
        return stringBuilder.toString();
    }
}
