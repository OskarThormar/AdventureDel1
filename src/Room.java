import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<Item> items;
    private ArrayList<Enemy> enemies;
    private String enemyRoar;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    //getter for items in the room
    public Item getItemByName(String indexName) {
        for (Item item : items) {
            if (item.getIndexName().equalsIgnoreCase(indexName)) {
                return item;
            }
        }
        return null; // Item not found in this room
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    public void removeEnemies(Enemy enemy){
        enemies.remove(enemy);
    }
    public String getEnemyRoar(){
        return enemyRoar;
    }
}
