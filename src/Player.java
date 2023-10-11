import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private Room currentRoom;
    private String currentWeapon;
    private String currentWeaponType;
    private int currentWeaponDamage;
    private int currentArrowCount;
    private final int unarmedDamage = 2;
    private String unarmed;
    private ArrayList<Item> inventory;
    private ArrayList<Item> equipment;
    //Kan implementeres senere
    private int health = 100;
    private int maxInventorySize;

    //added inventory to represent the player inventory size

    public Player(Room currentRoom, String currentWeapon, String currentWeaponType, int currentWeaponDamage, int maxInventorySize) {
        this.currentRoom = currentRoom;
        this.currentWeapon = currentWeapon;
        this.currentWeaponType = currentWeaponType;
        this.currentWeaponDamage = currentWeaponDamage;
        this.maxInventorySize = maxInventorySize;
        this.inventory = new ArrayList<>();
        this.equipment = new ArrayList<>();
    }

    //Check the items in the currentRoom before adding them to the inventory
    public void playerTake(Item item) {
        if (currentRoom.containsItem(item)) {
            if (inventory.size() < maxInventorySize) {
                inventory.add(item);
                currentRoom.removeItem(item);
            } else {
                System.out.println("Your inventory is full.");
            }
        } else {
            System.out.println("Item not found in this room");
        }
    }
    public Equipable playerEquip(String name) {
        for (Item weapon : inventory) {
            if (weapon.getName().equalsIgnoreCase(name)){
                if (weapon instanceof Weapon) {
                    if (equipment.isEmpty()) {
                        currentWeapon = ((Weapon) weapon).getName();
                        currentWeaponDamage = ((Weapon) weapon).getDamage();
                        inventory.remove(weapon);
                        equipment.add(weapon);
                        return Equipable.EQUIPPED;
                    }
                    if (equipment.size() == 1) {
                        currentWeapon = ((Weapon) weapon).getName();
                        currentWeaponDamage = ((Weapon) weapon).getDamage();
                        inventory.add(equipment.get(0));
                        equipment.remove(equipment.get(0));

                        inventory.remove(weapon);
                        equipment.add(weapon);
                        return Equipable.EQUIPPED;
                    }

                } else {
                    return Equipable.CANT;
                }
            } else {
                return Equipable.NOT_FOUND;
            }
        }
        return Equipable.ERROR;
    }

 /*   public Equipable playerEquip1(String name) {
        Item itemToEquip = null;
        for (Item weapon : inventory) {
            if (weapon.getName().equalsIgnoreCase(name)) {
                itemToEquip = weapon;
                break;
            }
            if (itemToEquip != null) {
                if (itemToEquip instanceof Weapon) {
                    currentWeapon = ((Weapon) itemToEquip).getName();
                    currentWeaponDamage = ((Weapon) itemToEquip).getDamage();
                    if ()
                        inventory.remove(itemToEquip);
                    equipment.add(itemToEquip);
                    return Equipable.EQUIPPED;
                } else {
                    return Equipable.CANT;
                }
            } return Equipable.NOT_FOUND;
        }

    }*/
    public void playerUnequip(Item item) {
        equipment.remove(item);
        inventory.add(item);
        setCurrentWeapon("unarmed");
        setCurrentWeaponDamage(unarmedDamage);
    }

/*    public Attackable playerAttack() {
        if (enemiesInRoom() != null){
            for (Enemy enemy : enemiesInRoom()){
                int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                enemy.setEnemyHealth(healthLeftEnemy);
                if (enemy.getEnemyHealth() < 1){
                    enemiesArrayList().remove(enemy);
                    System.out.println(enemy.getEnemyName() + "has died");
                }
                System.out.println("monster liv tilbage " + healthLeftEnemy);
                if (enemy.getEnemyHealth() > 0){
                    int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                    setPlayerHealth(healthLeftPlayer);
                    System.out.println(" spiller liv tilbage " + healthLeftPlayer);
                } else {
                    System.out.println(enemy.getEnemyName() + "is already dead");
                }
            }

        }
    }*/

    public void setCurrentWeapon(String currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void setCurrentWeaponDamage(int currentWeaponDamage) {
        this.currentWeaponDamage = currentWeaponDamage;
    }

    public String getCurrentWeapon(){
        return currentWeapon;
    }
    public int getCurrentWeaponDamage() {
        return currentWeaponDamage;
    }
    public String getCurrentWeaponType(){
        return currentWeaponType;
    }
    public void setCurrentWeaponType(String currentWeaponType){
        this.currentWeaponType = currentWeaponType;
    }
    public void setCurrentArrowCount(Item arrowCount){
        inventory.add(arrowCount);
    }

    //Allows the player to drop the item, and add the item to the current room.
    public void dropItem(String itemName, Room currentRoom) {
        Item itemToDrop = null;
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop != null) {
            inventory.remove(itemToDrop);
            currentRoom.addItem(itemToDrop);
        }
    }

    //retrieves the currentroom of the player
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public List<Item> itemsInRoom(){
        return currentRoom.getItems();
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public void move(String direction) {
        Room nextRoom = switch (direction) {
            case "north", "n" -> currentRoom.getNorth();
            case "east", "e" -> currentRoom.getEast();
            case "west", "w" -> currentRoom.getWest();
            case "south", "s" -> currentRoom.getSouth();
            default -> null;
        };
        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public List<Item> showInventory() {
        return inventory;
    }
    public ArrayList<Item>showEquipment(){
        return equipment;
    }
    public int getPlayerHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
    }

    public Item findItem(String name) {
        for (Item item : inventory) {
            if (item.getName().startsWith(name)) {
                return item;
            }
        }
        return null;
    }



    public Eatable playerEat(String name) {
        Item itemToEat = null;
        for (Item food : inventory) {
            if (food.getName().equalsIgnoreCase(name)) {
                itemToEat = food;
                break;
            }
        }
        if (itemToEat != null) {
            if (itemToEat instanceof Food) {
                int healthRestored = ((Food) itemToEat).getHealth();
                health += healthRestored;
                inventory.remove(itemToEat);
                return Eatable.EATEN;
            } else {
                return Eatable.CANT;
        }
        } else {
            return Eatable.NOT_FOUND;
        }

    }
    public ArrayList<Enemy> enemiesInRoom(){
        return currentRoom.getEnemies();
    }
    public Attackable playerAttack() {
        if (enemiesInRoom() != null){
            for (Enemy enemy : enemiesInRoom()){
                if (Objects.equals(getCurrentWeaponType(), "Ranged")){
                    if (inventory.contains())
                    int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                    enemy.setEnemyHealth(healthLeftEnemy);
                    if (enemy.getEnemyHealth() > 0){
                        System.out.println("monster liv tilbage " + healthLeftEnemy);
                    }
                    if (enemy.getEnemyHealth() > 0){
                        int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                        setPlayerHealth(healthLeftPlayer);
                        System.out.println(" spiller liv tilbage " + healthLeftPlayer);
                        return Attackable.SUCCESS;
                    } else {
                        System.out.println(enemy.getEnemyName() + " died");
                        System.out.println("It dropped: ");
                        currentRoom.addItem(enemy.getEnemyItems());
                        currentRoom.removeEnemies(enemy);

                        System.out.println(currentRoom.getItems());
                        return Attackable.CANT;
                    }
                }
                if (Objects.equals(getCurrentWeaponType(), "Melee")){
                    int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                    enemy.setEnemyHealth(healthLeftEnemy);
                    if (enemy.getEnemyHealth() > 0){
                        System.out.println("monster liv tilbage " + healthLeftEnemy);
                    }
                    if (enemy.getEnemyHealth() > 0){
                        int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                        setPlayerHealth(healthLeftPlayer);
                        System.out.println(" spiller liv tilbage " + healthLeftPlayer);
                        return Attackable.SUCCESS;
                    } else {
                        System.out.println(enemy.getEnemyName() + " died");
                        System.out.println("It dropped: ");
                        currentRoom.addItem(enemy.getEnemyItems());
                        currentRoom.removeEnemies(enemy);

                        System.out.println(currentRoom.getItems());
                        return Attackable.CANT;
                    }
                }
            }

        } return null;
    }

}
