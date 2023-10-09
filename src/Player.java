import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private Player currentWeapon;
    private List<Item> inventory;
    private List<Item> equipment;
    private int maxInventorySize;
    private int health = 100;

    //added inventory to represent the player inventory size
    public Player(Room startingRoom, int maxInventorySize) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.maxInventorySize = maxInventorySize;
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
        Item itemToEquip = null;
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemToEquip = item;
                break;
            }
        }
        if (itemToEquip != null) {
            if (itemToEquip instanceof Weapon) {
                inventory.remove(itemToEquip);
                equipment.add(itemToEquip);
                return Equipable.EQUIPPED;
            } else {
                return Equipable.CANT;
            }
        } return Equipable.NOT_FOUND;
    }
    public void playerAttack(String name){

    }

    public List<Item> getEquipment(){
        return equipment;
    }

    public Player getCurrentWeapon (){
        return currentWeapon;
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
        Room nextRoom = null;

        switch (direction) {
            case "north":
            case "n":
                nextRoom = currentRoom.getNorth();
                break;
            case "east":
            case "e":
                nextRoom = currentRoom.getEast();
                break;
            case "west":
            case "w":
                nextRoom = currentRoom.getWest();
                break;
            case "south":
            case "s":
                nextRoom = currentRoom.getSouth();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public List<Item> showInventory() {
        return inventory;
    }

    public List<Item> look() {
        return currentRoom.getItems();
    }

    public int healthPoints() {
        return health;
    }

    public void setHealthPoints(int health) {
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
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemToEat = item;
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

    public String floorItemName(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : currentRoom.getItems()){
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Player{" +
                "currentRoom=" + currentRoom +
                '}';
    }
}
