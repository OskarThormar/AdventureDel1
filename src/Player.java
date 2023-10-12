import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private Room currentRoom;
    private Enemy enemy;
    private boolean equipped = false;
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
        this.equipment = new ArrayList<>(1);
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
 /*   public String getIndexedTrackPlaylist(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Track track : playlist){
            stringBuilder.append(playlist.indexOf(track) + 1);
            stringBuilder.append(" ");
            stringBuilder.append(track);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String toString(){
        String favoriteIcon = "";
        if (isFavorite()){
            favoriteIcon = "\u2764";
        }
        return title + " - " + artist + " " + favoriteIcon;
    }
    public boolean isEquipped(){
        return equipped;
    }*/

    public Equipable playerEquip(String indexName) {
        for (Item item : inventory) {
            if (item.getIndexName().equalsIgnoreCase(indexName) ) {
                if (item instanceof Weapon){
                    if (item instanceof MeleeWeapon){
                        if (equipment.size() == 1){
                            Item equippedItem = equipment.get(0);
                            equipment.remove(equippedItem);
                            equipment.add(item);
                            //setCurrentWeaponType(equipment.get(0).getCurrentWeaponType());
                            //setCurrentWeaponType(((Weapon) item).getType());
                            //setCurrentWeapon(indexName);
                            //setCurrentWeaponDamage(((Weapon) item).getDamage());
                            return Equipable.EQUIPPED;
                        } else {
                            equipment.add(item);
                            //setCurrentWeaponType(equipment.get(0).getCurrentWeaponType());
                            //setCurrentWeaponType(((Weapon) item).getType());
                            return Equipable.EQUIPPED;
                            //setCurrentWeapon(indexName);
                            //setCurrentWeaponDamage(((Weapon) item).getDamage());
                        }
                    }
                    if (item instanceof RangedWeapon){
                        if (equipment.size() == 1){
                            Item equippedItem = equipment.get(0);
                            equipment.remove(equippedItem);
                            equipment.add(item);
                            //setCurrentWeaponType(equipment.get(0).getCurrentWeaponType());
                            //setCurrentWeaponType(((Weapon) item).getType());
                            //setCurrentWeapon(indexName);
                            //setCurrentWeaponDamage(((Weapon) item).getDamage());
                            return Equipable.EQUIPPED;
                        } else {
                            equipment.add(item);
                            //setCurrentWeaponType(equipment.get(0).getCurrentWeaponType());
                            //setCurrentWeaponType(((Weapon) item).getType());
                            return Equipable.EQUIPPED;
                            //setCurrentWeapon(indexName);
                            //setCurrentWeaponDamage(((Weapon) item).getDamage());
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
            //equipment.remove(equipment.get(0));
            //inventory.add(item);
            setCurrentWeapon("Unarmed ");
            setCurrentWeaponDamage(unarmedDamage);
            setCurrentWeaponType("Melee");
        }
    public void setCurrentWeapon(String currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void setCurrentWeaponDamage(int currentWeaponDamage) {
        this.currentWeaponDamage = currentWeaponDamage;
    }

    public String getCurrentWeapon() {
        return currentWeapon;
    }
    public ArrayList<Item> getCurrentWeaponArray(){
        return equipment;
    }
    public Item getCurrentWeaponArray1(){
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
    public String getEnemyRoar(){
        return enemy.getEnemyRoar();
    }


    public List<Item> itemsInRoom() {
        return currentRoom.getItems();
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
  /*  public void move1(String direction){
        Room nextRoom = switch (direction){
            case "north", "n":
                currentRoom.getNorth();
            case "south", "s":
                currentRoom.getSouth();
            default:
                null:



        };
        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }*/

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

    public ArrayList<Item> showEquipment() {
        return equipment;
    }
    public Item getInventoryByItemName(String indexName){
        for (Item item : inventory) {
            if (item.getIndexName().equalsIgnoreCase(indexName)) {
                return item;
            }
        }
        return null; // Item not found in this room
    }

    public int getPlayerHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
    }

    public Item findItem(String indexName) {
        for (Item item : inventory) {
            if (item.getIndexName().startsWith(indexName)) {
                return item;
            }
        }
        return null;
    }


    public Eatable playerEat(String indexName) {
        if (indexName != null) {
            for (Item food : inventory) {
                if (food.getIndexName().equalsIgnoreCase(indexName)) {
                    if (food instanceof Food) {
                        int healthRestored = ((Food) food).getHealth();
                        health += healthRestored;
                        inventory.remove(food);
                        return Eatable.EATEN;
                    } else {
                        return Eatable.CANT;
                    }
                } else {
                    return Eatable.NOT_FOUND;
                }
            }
        } return null;
    }
    /*public Eatable playerEat(String name) {
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

    }*/

    public ArrayList<Enemy> enemiesInRoom() {
        return currentRoom.getEnemies();
    }

    public Attackable playerAttack() {
        if (enemiesInRoom() != null) {
            for (Enemy enemy : enemiesInRoom()) {
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
                        System.out.println("It dropped: ");
                        System.out.println(enemy.getEnemyItems());
                        currentRoom.addItem(enemy.getEnemyItems());
                        currentRoom.removeEnemies(enemy);
                        return Attackable.CANT;
                    }
                }
            }
        } else {
            if (enemiesInRoom() == null){
                if (equipment.get(0) instanceof RangedWeapon) {
                    if (currentArrowCount > 0){
                        System.out.println("You fired an arrow, but the room is empty. Practice makes perfect i guess");
                        setCurrentArrowCount(getCurrentArrowCount() - 1);
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
