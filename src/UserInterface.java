import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;
    private Eatable result;

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
        boolean menuLoop = true;

        while (menuLoop) {
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
                case "help", "info":
                    help();
                    break;
                case "quit", "exit", "bye":
                    System.out.println("Thank you for playing Adventure Game! Come back another time :-)");
                    System.exit(0);
                    break;
                case "take":
                   if (userSelection.length > 1) {
                       String secondWordTake = userSelection[1];
                       playerTake(secondWordTake);
                   } else {
                       System.out.println("What do you want to take?");
                   }
                    break;
                case "drop":
                    String secondWordDrop = userSelection[1];
                    playerDrop(secondWordDrop);
                    break;
                case "eat":
                    if (userSelection.length > 1) {
                        String secondWordEat = userSelection[1];
                        Eatable result = adventure.playerEat(secondWordEat);
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
                            case EATEN:
                                System.out.println("You have eaten and gained health.");
                                System.out.println("Current health: " + adventure.getPlayerHealth());
                                break;
                            default:
                                System.err.println("Internal error");
                        }
                    } else {
                        System.out.println("eat what?");
                    }
                    break;
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
        } menuLoop = false;
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
        System.out.println("You found");
        for (Item item : adventure.itemsInRoom()) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    //pick up item method
    public void playerTake(String userSelection){
            //String itemName = userSelection.substring(5);
            Item itemToTake = adventure.getCurrentRoom().getItemByName(userSelection);
            if (itemToTake != null) {
                adventure.getPlayer().playerTake(itemToTake);
                System.out.println("You picked up " + userSelection);
            } else {
                System.out.println("Item not found in this room");
            }
        }

    //drop item method
    public void playerDrop(String userSelection) {
        //String itemName = userSelection.substring(5);
        Player player = adventure.getPlayer();
        player.dropItem(userSelection, adventure.getCurrentRoom());
        System.out.println("you dropped " + userSelection);
    }

    public void showInventory() {
            System.out.println("Inventory:");
            for (Item item : adventure.showInventory()) {
                if (item != null) {
                    System.out.println(item);
                }
            }
        }
//    public void eatFood(){
//        for (Item food : adventure.showInventory()){
//            System.out.println(food);
//            if (food instanceof Food){
//                ((Food) food).foodObjekt();
//
//            }
//        }
//    }
    public void showHealth(){
        System.out.println(adventure.getPlayerHealth());
    }
}

