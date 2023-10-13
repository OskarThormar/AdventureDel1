import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private Room currentRoom;
    private Enemy enemy;
    private String currentWeapon;
    private String currentWeaponType;
    private int currentWeaponDamage;
    private int currentArrowCount;
    private final int unarmedDamage = 2;
    private String unarmed;
    private ArrayList<Item> inventory;
    private ArrayList<Item> equipment;
    private int health = 100;

    public Player(Room currentRoom, String currentWeapon, String currentWeaponType, int currentWeaponDamage) {
        this.currentRoom = currentRoom;
        this.currentWeapon = currentWeapon;
        this.currentWeaponType = currentWeaponType;
        this.currentWeaponDamage = currentWeaponDamage;
        this.inventory = new ArrayList<>();
        this.equipment = new ArrayList<>();
    }

    //Check the items in the currentRoom before adding them to the inventory
    public void playerTake(Item item) {
        if (currentRoom.containsItem(item)) {
            if (item instanceof RangedWeaponAmmo) {
                setCurrentArrowCount(((RangedWeaponAmmo) item).getArrows());
                currentRoom.removeItem(item);
            } else {
                inventory.add(item);
                currentRoom.removeItem(item);
            }
        } else {
            System.out.println("Item not found in this room");
        }
    }

    public Equipable playerEquip(String indexName) {
        for (Item item : inventory) {
            if (item.getIndexName().equalsIgnoreCase(indexName) ) {
                if (item instanceof Weapon){
                    if (item instanceof MeleeWeapon){
                        if (equipment.size() == 1){
                            Item equippedItem = equipment.get(0);
                            equipment.remove(equippedItem);
                            equipment.add(item);
                            Item newEquippedItem = equipment.get(0);
                            setCurrentWeaponDamage(newEquippedItem.getCurrentWeaponDamage());
                            setCurrentWeaponType(newEquippedItem.getCurrentWeaponType());
                            return Equipable.EQUIPPED;
                        } else {
                            equipment.add(item);
                            Item newEquippedItem = equipment.get(0);
                            setCurrentWeaponDamage(newEquippedItem.getCurrentWeaponDamage());
                            setCurrentWeaponType(newEquippedItem.getCurrentWeaponType());
                            return Equipable.EQUIPPED;
                        }
                    }
                    if (item instanceof RangedWeapon){
                        if (equipment.size() == 1){
                            Item equippedItem = equipment.get(0);
                            equipment.remove(equippedItem);
                            equipment.add(item);
                            Item newEquippedItem = equipment.get(0);
                            setCurrentWeaponDamage(newEquippedItem.getCurrentWeaponDamage());
                            setCurrentWeaponType(newEquippedItem.getCurrentWeaponType());
                            return Equipable.EQUIPPED;
                        } else {
                            equipment.add(item);
                            Item newEquippedItem = equipment.get(0);
                            setCurrentWeaponDamage(newEquippedItem.getCurrentWeaponDamage());
                            setCurrentWeaponType(newEquippedItem.getCurrentWeaponType());
                            return Equipable.EQUIPPED;
                    }

                    }
                } else {
                    return Equipable.CANT;
                }
            }
        }
            return Equipable.NOT_FOUND;
    }


    public void playerUnequip() {
        if (!equipment.isEmpty()){
            Item equippedItem = equipment.get(0);
            equipment.remove(equippedItem);
        }
            setCurrentWeapon("Unarmed");
            setCurrentWeaponDamage(unarmedDamage);
            setCurrentWeaponType("unarmed");
    }


    public void setCurrentWeapon(String currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void setCurrentWeaponDamage(int currentWeaponDamage) {
        this.currentWeaponDamage = currentWeaponDamage;
    }
    public Item getCurrentWeaponArray(){
        for (Item equipment : equipment) {
            return equipment;
        }
        return null;
    }

    public int getCurrentWeaponDamage() {
        return currentWeaponDamage;
    }

    public String getCurrentWeaponType() {
        return currentWeaponType;
    }

    public void setCurrentWeaponType(String currentWeaponType) {
        this.currentWeaponType = currentWeaponType;
    }

    public void setCurrentArrowCount(int currentArrowCount) {
        this.currentArrowCount = currentArrowCount;
    }

    public int getCurrentArrowCount() {
        return currentArrowCount;
    }
    public void dropItem(String indexName, Room currentRoom) {
        Item itemToDrop = null;
        for (Item item : inventory) {
            if (item.getIndexName().equalsIgnoreCase(indexName)) {
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop != null) {
            inventory.remove(itemToDrop);
            currentRoom.addItem(itemToDrop);
        }
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public List<Item> itemsInRoom() {
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

    public int getPlayerHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
    }
    public Eatable playerEat(String indexName) {
            for (Item food : inventory) {
                if (food instanceof Food) {
                    if (food.getIndexName().equalsIgnoreCase(indexName)) {
                        int healthRestored = ((Food) food).getHealth();
                        health += healthRestored;
                        inventory.remove(food);
                        return Eatable.EATEN;
                    } else {
                        return Eatable.CANT;
                    }
                }
        } return null;
    }

    public ArrayList<Enemy> enemiesInRoom() {
        return currentRoom.getEnemies();
    }

    public Attackable playerAttack() {
        if (!enemiesInRoom().isEmpty()) {
            for (Enemy enemy : enemiesInRoom()) {
                if (Objects.equals(getCurrentWeaponType(), "unarmed")){
                    int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                    enemy.setEnemyHealth(healthLeftEnemy);
                    System.out.println("You hit the " + enemy.getEnemyName());
                    if (enemy.getEnemyHealth() > 0) {
                        System.out.println("Your enemy have: " + healthLeftEnemy + " health left");
                    }
                    if (enemy.getEnemyHealth() > 0) {
                        int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                        setPlayerHealth(healthLeftPlayer);
                        System.out.println(enemy.getEnemyName() + " hits you back");
                        System.out.println("You have: " + healthLeftPlayer + " health left");
                        return Attackable.SUCCESS;
                    } else {
                        System.out.println(enemy.getEnemyName() + " died");
                        System.out.println("It dropped: ");
                        System.out.println(enemy.getEnemyItems());
                        currentRoom.addItem(enemy.getEnemyItems());
                        currentRoom.removeEnemies(enemy);
                        return Attackable.CANT;
                    }
                }
                if (equipment.get(0) instanceof RangedWeapon) {
                    if (currentArrowCount > 0) {
                        int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                        enemy.setEnemyHealth(healthLeftEnemy);
                        setCurrentArrowCount(getCurrentArrowCount() - 1);
                        System.out.println("You fired an arrow at " + enemy.getEnemyName() + " you have " + getCurrentArrowCount() + " arrows left");
                        if (enemy.getEnemyHealth() > 0) {
                            System.out.println("Your enemy have: " + healthLeftEnemy + " health left");
                        }
                        if (enemy.getEnemyHealth() > 0) {
                            int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                            setPlayerHealth(healthLeftPlayer);
                            System.out.println("You have: " + healthLeftPlayer + " health left");
                            return Attackable.SUCCESS;
                        } else {
                            System.out.println(enemy.getEnemyName() + " died");
                            System.out.println("It dropped: ");
                            System.out.println(enemy.getEnemyItems());
                            currentRoom.addItem(enemy.getEnemyItems());
                            currentRoom.removeEnemies(enemy);
                            return Attackable.CANT;
                        }
                    } else {
                        System.out.println("You dont have any arrows");
                        System.out.println(enemy.getEnemyName() + " attacks!");
                        int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                        setPlayerHealth(healthLeftPlayer);
                        System.out.println("You have: " + healthLeftPlayer + " health left");
                    }
                }
                if (equipment.get(0) instanceof MeleeWeapon) {
                    int healthLeftEnemy = enemy.getEnemyHealth() - getCurrentWeaponDamage();
                    enemy.setEnemyHealth(healthLeftEnemy);
                    System.out.println("You hit the " + enemy.getEnemyName());
                    if (enemy.getEnemyHealth() > 0) {
                        System.out.println("Your enemy have: " + healthLeftEnemy + " health left");
                    }
                    if (enemy.getEnemyHealth() > 0) {
                        int healthLeftPlayer = getPlayerHealth() - enemy.getEnemyDamage();
                        setPlayerHealth(healthLeftPlayer);
                        System.out.println(enemy.getEnemyName() + " hits you back");
                        System.out.println("You have: " + healthLeftPlayer + " health left");
                        return Attackable.SUCCESS;
                    } else {
                        System.out.println(enemy.getEnemyName() + " died");
                        if (enemy.getEnemyItems() != null){
                            System.out.println("It dropped: ");
                            System.out.println(enemy.getEnemyItems());
                            currentRoom.addItem(enemy.getEnemyItems());
                            currentRoom.removeEnemies(enemy);
                        } else {
                            System.out.println("It dropped: ");
                            System.out.println("Nothing");
                            currentRoom.removeEnemies(enemy);
                        }
                        return Attackable.CANT;
                    }
                }
            }
        }
        if (enemiesInRoom().isEmpty()){
            if (Objects.equals(getCurrentWeaponType(), "unarmed")){
                System.out.println("You don't have any weapon equipped. You are swinging in the air, but the room is empty. Practice makes perfect i guess");
                return Attackable.NO_ENEMY;
            } else {
                if (equipment.get(0) instanceof RangedWeapon) {
                    if (currentArrowCount > 0){
                        System.out.println("You fired an arrow, but the room is empty. Practice makes perfect i guess");
                        setCurrentArrowCount(getCurrentArrowCount() - 1);
                        System.out.println(getCurrentArrowCount() + " arrows left");
                        return Attackable.NO_ENEMY;
                    } else {
                        System.out.println("You dont have any arrows, the room is also empty, what are you doing?");
                    }
                }
                if (equipment.get(0) instanceof MeleeWeapon) {
                    System.out.println("You are swinging in the air, but the room is empty. Practice makes perfect i guess");
                    return Attackable.NO_ENEMY;
                }
            }

        }
        return null;
    }

}
