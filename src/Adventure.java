import java.util.ArrayList;
import java.util.List;

public class Adventure {
    private Player player;
    private Map map;
    private Enemy enemy;
    private Item item;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartingRoom(), "Unarmed", "unarmed", 2);
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
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public Player getPlayer() {
        return player;
    }
    public List<Item> showInventory() {
        return player.showInventory();
    }
    public int getPlayerHealth(){
        return player.getPlayerHealth();
    }
    public Eatable playerEat(String name){
        return player.playerEat(name);
    }
    public Equipable playerEquip(String indexName){
        return player.playerEquip(indexName);
    }
    public Item getCurrentWeaponArray(){
        return player.getCurrentWeaponArray();
    }
    public int getCurrentArrowCount(){
        return player.getCurrentArrowCount();
    }
    public void playerUnequip(){
        this.player.playerUnequip();
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
