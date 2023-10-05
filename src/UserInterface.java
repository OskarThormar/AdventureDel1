import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;
    private ReturnMessage result;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startProgram() {
        adventure.initializeGame();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("""
                ---------------------------------------|
                 - Type 'Help' to show instructions    |
                 - Type 'Start' to start the game      |
                 - Type 'Exit' to exit the game        |
                ---------------------------------------|
                """);

        String userSelection = keyboard.nextLine();

        switch (userSelection.toLowerCase()) {
            case "help":
                help();
            case "start":
                startGame();
                break;
            case "exit":
                System.out.println("Have a great day");
                System.exit(0);
                break;
            default:
                System.out.println("Choose an option from above");
                break;
        }
    }

    public void startGame() {
        System.out.println(adventure.getCurrentRoom().getDescription());
        handleUserInput();
    }

    private void handleUserInput() {
        boolean firstlook = true;

        while (firstlook) {
            String[] userSelection = keyboard.nextLine().toLowerCase().trim().split(" ");
            String firstWord = userSelection[0];
            //String userSelection = keyboard.nextLine().toLowerCase().trim();
            switch (firstWord) {
                case "look":
                    userLook();
                    break;
                case "inventory":
                    showInventory();
                    break;
                case "health":
                    showHealth();
                    break;
                case "help":
                case "info":
                    help();
                    break;
                case "quit":
                case "exit":
                case "bye":
                    System.out.println("Thank you for playing Adventure Game! Come back another time :-)");
                    System.exit(0);
                    break;
                case "take":
                    String secondWord1 = userSelection[1];
                    playerPickUpItem(secondWord1);
                case "drop":
                    String secondWordDrop = userSelection[1];
                    playerDrop(secondWordDrop);
                    break;
                case "eat":
                    String secondWord3 = userSelection[1];
                    System.out.println("Enter the name of the item you want to eat:");
                    // String itemName = keyboard.nextLine().toLowerCase();
                    result = eat(secondWord3);
                    switch (result) {
                        case NOT_FOUND:
                            System.out.println("No such thing");
                            break;
                        case CANT:
                            System.out.println("You can't eat that");
                            break;
                        case OK:
                            System.out.println("You have eaten ..");
                            break;
                        default:
                            System.err.println("Internal error");
                    }
                case "go":
                    if (userSelection.length > 1) {
                        String secondWordMove = userSelection[1];
                        switch (secondWordMove) {
                            case "north", "south", "west", "east":
                                adventure.move(secondWordMove);
                                System.out.println(adventure.getCurrentRoom().getDescription());
                                break;
                            default:
                                System.out.println("Invalid direction. ");
                                break;
                        }
                    } else {
                        System.out.println(" What way?");
                    }
                    break;
                default:
                    System.out.println("I don't understand");
                    break;
            }
        } while (firstWord.equals(exit));
    }

    public void help() {
        System.out.println("== Help Menu ==");
        System.out.println("Basic Needs:");
        System.out.println("- Water: Stay hydrated during your adventure.");
        System.out.println("- Food: Restore your energy, but be aware! Some food can be poisonous.");

        System.out.println("Tools and Weapons:");
        System.out.println("- Sword: Use for close combat.");
        System.out.println("- Shield: Provides defense against enemy attacks.");

/*        System.out.println("Assistance:");
        System.out.println("- Elf for Dragon: Seek help from the Elf to battle the Dragon.");
        System.out.println("- Fairies: Call upon fairies for assistance.");
        System.out.println("- Summon Familiar: Summon a magical being to assist you.");
        System.out.println("- Healing Circle: Create a healing circle to restore health.");
        System.out.println("- Clairvoyance: See enemy positions or hidden paths.");
        System.out.println("- Summon Allies: Call upon allies to aid you in battle.");
        System.out.println("Magic Potion for Temporary Invisibility: Brew a potion for temporary invisibility");*/

        System.out.println("Navigation:");
        System.out.println("- N: Go North");
        System.out.println("- E: Go East");
        System.out.println("- S: Go South");
        System.out.println("- R: Go Right");
    }

    private void userLook() {
        //adventure.itemsInRoom();

       // String itemsInRoom = adventure.look();
       System.out.println("You found " + adventure.itemsInRoom());
    }

    //pick up item method
    public void playerPickUpItem(String userSelection){
            String itemName = userSelection.substring(1);
            Item itemToPickUp = adventure.getCurrentRoom().getItemByName(itemName);
            if (itemToPickUp != null) {
                adventure.getPlayer().pickUpItem(itemToPickUp);
                System.out.println("You picked up " + itemName);
            } else {
                System.out.println("Item not found in this room");
            }
        }

    //drop item method
    public void playerDrop(String userSelection) {
        //String itemName = userSelection.substring(5);
        Player player = adventure.getPlayer();
        player.dropItem(itemName, adventure.getCurrentRoom());
    }

    public void showInventory() {
            System.out.println("Inventory:");
            for (Item item : adventure.showInventory()) {
                if (item != null) {
                    System.out.println(item);
                }
            }
        }
    public void eatFood(){
        for (Item food : adventure.showInventory()){
            System.out.println(food);
            if (food instanceof Food){
                ((Food) food).foodObjekt();

            }
        }
    }
    public void showHealth(){
        System.out.println(adventure.getPlayerHealth());
    }
    public ReturnMessage eat(String name){
        // look in players inventory
        Item item = adventure.findItem(name);
        if (item != null){
            if (item instanceof Food){
                adventure.showInventory().remove(item);
                System.out.println("You ate " + item.getName());
                return ReturnMessage.OK;
            } else {
                return ReturnMessage.CANT;
            }
        } else {
            return ReturnMessage.NOT_FOUND;
        }
    }

}

