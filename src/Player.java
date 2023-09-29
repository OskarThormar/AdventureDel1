import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;
    private int maxInventorySize;

    //added inventory to represent the player inventory size
    public Player(Room startingRoom, int maxInventorySize) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.maxInventorySize = maxInventorySize;
    }

    //Check the items in the currentRoom before adding them to the inventory
    public void pickUpItem(Item item) {
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
            System.out.println("You dropped " + itemName + " in " + currentRoom.getName());
        } else {
            System.out.println("You don't have the item " + itemName + " in your inventory.");
        }
    }

    //retrieves the currentroom of the player
    public Room getCurrentRoom() {
        return currentRoom;
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
    public List<Item> showInventory()
    {
        return inventory;
    }

    public List<Item> look () {
        return currentRoom.getItems();
    }
}
