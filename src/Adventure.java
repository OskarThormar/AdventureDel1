import java.util.ArrayList;
import java.util.List;

public class Adventure {
    private Player player;
    private Map map;
    private Enemy enemy;
    private Item item;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartingRoom(), "Unarmed", "Melee", 2);

        initializeGame();
    }
    public String getIndexName(){
        return item.getIndexName();
    }

    //sets the players initial starting room
    public void initializeGame() {
        player.setCurrentRoom(map.getStartingRoom());
    }

    public void move(String direction){
        this.player.move(direction);
    }

    //retrieves the current room of the player
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    //Allow classes to access player
    public Player getPlayer() {
        return player;
    }
    public List<Item> showInventory() {
        return player.showInventory();
    }
    public Item getInventoryByItemName(String indexName){
        return player.getInventoryByItemName(indexName);
    }
    public ArrayList<Item>showEquipment(){
        return player.showEquipment();
    }
    public int getPlayerHealth(){
        return player.getPlayerHealth();
    }
    public void setPlayerHealth(int health){
        this.player.setPlayerHealth(health);
    }
    public Eatable playerEat(String name){
        return player.playerEat(name);
    }
    public Equipable playerEquip(String indexName){
        return player.playerEquip(indexName);
    }
    public String getCurrentWeapon(){
        return player.getCurrentWeapon();
    }
    public Item getCurrentWeaponArray(){
        return player.getCurrentWeaponArray1();
    }
    public void setCurrentArrowCount(int currentArrowCount){
        this.player.setCurrentArrowCount(currentArrowCount);
    }
    public int getCurrentArrowCount(){
        return player.getCurrentArrowCount();
    }
    public void playerUnequip(){
        this.player.playerUnequip();
    }

    public int getCurrentWeaponDamage(){
        return player.getCurrentWeaponDamage();
    }
    public Item findItem(String name){
        return player.findItem(name);
    }
    public List<Item> itemsInRoom(){
        return player.itemsInRoom();
    }
    public ArrayList<Enemy> enemiesInRoom(){
        return player.enemiesInRoom();
    }
    public Attackable playerAttack(){
        return player.playerAttack();
    }
}
