import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startProgram() {
        adventure.initializeGame();

        System.out.println("✨\uD83E\uDDD9\uD83C\uDFFCWelcome to the Adventure Game!\uD83E\uDDD9\uD83C\uDFFC✨");
        System.out.println("""
                ---------------------------------------|
                 - 📜Type 'Help' to show instructions  |
                 - ⛰️Type 'Start' to start the game    |
                 - 🔚Type 'Exit' to exit the game      |
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
                System.out.println("Have a great day \uD83C\uDF1E");
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
            switch (firstWord) {
                case "look":
                    userLook();
                    enemiesInRoom();
                    break;
                case "inventory":
                    showInventory();
                    showEquipment();
                    break;
                case "health":
                    showHealth();
                    break;
                case "help", "info":
                    help();
                    break;
                case "quit", "exit", "bye":
                    System.out.println("Thank you for playing Adventure Game! Come back another time \uD83D\uDC4B");
                    System.exit(0);
                    break;
                case "take":
                    if (userSelection.length > 2){
                        playerTake(userSelection[1].trim()+userSelection[2].trim());
                    }
                    if (userSelection.length < 3) {
                       playerTake(userSelection[1]);
                    }
                    break;
                case "drop":
                    adventure.playerUnequip();
                    if (userSelection.length > 2){
                        playerDrop(userSelection[1].trim()+userSelection[2].trim());
                    }
                    if (userSelection.length < 3) {
                        playerDrop(userSelection[1]);
                    }
                    break;
                case "equip":
                    if (userSelection.length == 2){
                        Equipable result = adventure.playerEquip(userSelection[1]);
                        switch (result) {
                            case NOT_FOUND:
                                System.out.println("There's nothing to equip");
                                break;
                            case CANT:
                                System.out.println("You can't equip that");
                                break;
                            case EQUIPPED:
                                System.out.println("You have equipped: " + adventure.getCurrentWeaponArray());
                                break;
                            default:
                                System.out.println("ERROR");
                                break;
                        }
                    } else {
                        Equipable result = adventure.playerEquip(userSelection[1].trim() + userSelection[2].trim());
                        switch (result) {
                            case NOT_FOUND:
                                System.out.println("There's nothing to equip ");
                                break;
                            case CANT:
                                System.out.println("You can't equip that");
                                break;
                            case EQUIPPED:
                                System.out.println("You have equipped: " + adventure.getCurrentWeaponArray());
                                break;
                            default:
                                System.out.println("ERROR");
                                break;
                        }
                    }
                    break;
                    case "eat":
                            if (userSelection.length == 2) {
                                Eatable playerToEat = adventure.playerEat(userSelection[1]);
                                switch (playerToEat) {
                                    case NOT_FOUND:
                                        System.out.println("No such thing ");
                                        break;
                                    case CANT:
                                        System.out.println("You can't eat that");
                                        break;
                                    case EATEN:
                                        System.out.println("You have eaten and gained health ❤\uFE0F");
                                        System.out.println("Current healthstatus: " + adventure.getPlayerHealth());
                                        break;
                                    default:
                                        System.err.println("Internal error");
                                        break;
                                }
                            } else {
                                Eatable playerToEat = adventure.playerEat(userSelection[1].trim() + userSelection[2].trim());
                                switch (playerToEat) {
                                    case NOT_FOUND:
                                        System.out.println("No such thing");
                                        break;
                                    case CANT:
                                        System.out.println("You can't eat that");
                                        break;
                                    case EATEN:
                                        System.out.println("You have eaten and gained health ❤\uFE0F");
                                        System.out.println("Current healthstatus: " + adventure.getPlayerHealth());
                                        break;
                                    default:
                                        System.err.println("Internal error");
                                        break;
                                }
                            }
                            break;
                case "go":
                    if (userSelection.length > 1) {
                        switch (userSelection[1]) {
                            case "north", "south", "west", "east":
                                adventure.move(userSelection[1]);
                                if (!adventure.getCurrentRoom().getEnemies().isEmpty()){
                                    for (Enemy enemy : adventure.enemiesInRoom()){
                                        System.out.println(enemy.getEnemyRoar());
                                    }
                                }
                                System.out.println(adventure.getCurrentRoom().getDescription());
                                break;
                            default:
                                System.out.println("Invalid direction. ");
                                break;
                        }
                    } else {
                        System.out.println(" Which way would you like to go?");
                    }
                    break;
                case "attack":
                    adventure.playerAttack();
                    playerDeath();
                    break;
                default:
                    System.out.println("I don't understand");
                    break;
            }
        } menuLoop = false;
    }

    public void help() {
        System.out.println("\uD83C\uDD98 Help Menu \uD83C\uDD98");
        System.out.println("Basic Needs:");
        System.out.println("- Water: Stay hydrated during your adventure.");
        System.out.println("- Food: Restore your energy, but be aware! Some food can be poisonous.");

        System.out.println("Tools and Weapons:");
        System.out.println("- Sword: Use for close combat.");
        System.out.println("- Shield: Provides defense against enemy attacks.");

        System.out.println(" \uD83E\uDDED Navigation:");
        System.out.println("- N: Go North");
        System.out.println("- E: Go East");
        System.out.println("- S: Go South");
        System.out.println("- R: Go Right");
    }

    private void userLook() {
        System.out.println("You look around and see: ");
        for (Item item : adventure.itemsInRoom()) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public void playerTake(String userSelection){
            Item itemToTake = adventure.getCurrentRoom().getItemByName(userSelection);
            if (itemToTake != null) {
                System.out.println("You picked up " + itemToTake);
                adventure.getPlayer().playerTake(itemToTake);
            } else {
                System.out.println("Item not found in this room");
            }
        }

    public void playerDrop(String userSelection) {
        adventure.playerUnequip();
        Player player = adventure.getPlayer();
        player.dropItem(userSelection, adventure.getCurrentRoom());
        System.out.println("You have dropped " + userSelection);
    }

    public void showInventory() {
        System.out.println("\uD83C\uDF92 Inventory: ");
        for (Item item : adventure.showInventory()) {
            if (item instanceof Food) {
                Food foodItem = (Food) item;
                System.out.println(item.getName() + " • " + foodItem.getHealth() + " healthpoints! ");
            }
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                System.out.println(item.getName() + " • " + weapon.getDamage() + " damage! ");
            }
        }
        System.out.println(adventure.getCurrentArrowCount() + " Arrows");
    }
    public void showEquipment(){
        System.out.println("Equipment: ");
        if (adventure.getCurrentWeaponArray() != null){
            System.out.println(adventure.getCurrentWeaponArray());
        } else {
            System.out.println("Empty");
        }
    }

    public void showHealth(){
        System.out.println(adventure.getPlayerHealth());
    }
    public void playerDeath () {
        if (adventure.getPlayerHealth() < 1 ){
            System.out.println("YOU HAVE DIED! GAME OVER");
            System.exit(0);
        }
    }
    public void enemiesInRoom(){
        for (Enemy enemy : adventure.enemiesInRoom()){
            if (enemy != null){
                System.out.println(enemy);
            }
        }
    }
}

