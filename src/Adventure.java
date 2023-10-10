import java.util.ArrayList;
import java.util.List;

public class Adventure {
    private Player player;
    private Map map;

    public Adventure() {
        this.map = new Map();
        //set the player maximum inventory to
        this.player = new Player(map.getStartingRoom(), "Unarmed", 2, 5);

        initializeGame();
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
    public int getPlayerHealth(){
        return player.healthPoints();
    }
    public void setPlayerHealth(int health){
        this.player.setHealthPoints(health);
    }
    public Eatable playerEat(String name){
        return player.playerEat(name);
    }
    public Equipable playerEquip(String name){
        return player.playerEquip(name);
    }
    public String getCurrentWeapon(){
        return player.getCurrentWeapon();
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


/*    public void setCurrentWeaponUnarmed() {
        this.player.setUnarmed();
    }
    public void setCurrentWeaponUnarmedDamage(){
        this.player.setUnarmedDamage();
    }*/
}
