import java.util.ArrayList;
import java.util.List;
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
        //adventure.setCurrentWeaponUnarmed();
        //adventure.setCurrentWeaponUnarmedDamage();
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
                    //showEquipment();
                    //GØR PÆNT
                    System.out.println(adventure.getCurrentWeaponDamage());
                    System.out.println(adventure.getCurrentWeapon());
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
                   if (userSelection.length > 1) {
                       //String secondWordTake = userSelection[1];
                       playerTake(userSelection[1]);
                   } else {
                       System.out.println("What do you want to take?");
                   }
                    break;
                case "drop":
                    //secondword
                    playerDrop(userSelection[1]);
                    break;
                case "unequip":
                    if (userSelection.length > 1) {

                    }
                case "equip":
                    if (userSelection.length > 1) {
                        Equipable result = adventure.playerEquip(userSelection[1]);
                        switch (result) {
                            case NOT_FOUND:
                                System.out.println("no such thing1");
                                break;
                            case CANT:
                                System.out.println("You can't equip that");
                                break;
                            case EQUIPPED:
                                System.out.println("You have equipped: " + adventure.getCurrentWeapon());
                                break;
                            default:
                                System.out.println("ERROR");
                                break;
                        }
                    }
                case "eat":
                    if (userSelection.length > 1) {
                        Eatable result = adventure.playerEat(userSelection[1]);
                        switch (result) {
                            case NOT_FOUND:
                                System.out.println("No such thing");
                                break;
                            case CANT:
                                System.out.println("You can't eat that");
                                break;
                            case OK:
                                System.out.println("You have eaten: ");
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
                        System.out.println("Sorry, what would you like to eat?");
                    }
                    break;
                case "go":
                    if (userSelection.length > 1) {
                        //String secondWordMove = userSelection[1];
                        switch (userSelection[1]) {
                            case "north", "south", "west", "east":
                                adventure.move(userSelection[1]);
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
                    //playerAttack();
                    adventure.playerAttack();
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
        System.out.println("You have dropped " + userSelection);
    }

    public void showInventory() {
        System.out.println("\uD83C\uDF92 Inventory: ");
        for (Item item : adventure.showInventory()) {
            if (adventure.showInventory() != null) {
                System.out.println(item.getName());
                System.out.println(adventure.getCurrentArrowCount() + " Arrows");
            } else {
                System.out.println("You don't have any items in your inventory.");
            }
        }
    }

    public void showEquipment(){
        System.out.println("Equipment: ");
        if (adventure.showEquipment() != null){
            for (Item item : adventure.showEquipment()){
                System.out.println(item.getName());
                System.out.println("Damage per attack: " + adventure.getCurrentWeaponDamage());
            }
        } else {
            System.out.println("You are not wearing any equipment");
        }
    }

    public void showHealth(){
        System.out.println(adventure.getPlayerHealth());
    }
    public void enemiesInRoom(){
        System.out.println("Enemies in the room:");
        for (Enemy enemy : adventure.enemiesInRoom()){
            if (enemy != null){
                System.out.println(enemy);
            }
        }
    }
/*    public void playerAttack(){
        if (adventure.enemiesInRoom() != null){
            for (Enemy enemy : adventure.enemiesInRoom()){
                int healthLeftEnemy = enemy.getEnemyHealth() - adventure.getCurrentWeaponDamage();
                enemy.setEnemyHealth(healthLeftEnemy);
                if (enemy.getEnemyHealth() < 1){
                    adventure.enemyDeath();
                }

                }
                System.out.println("monster liv tilbage " + healthLeftEnemy);
                if (enemy.getEnemyHealth() > 0){
                    int healthLeftPlayer = adventure.getPlayerHealth() - enemy.getEnemyDamage();
                    adventure.setPlayerHealth(healthLeftPlayer);
                    System.out.println(" spiller liv tilbage " + healthLeftPlayer);
                } else {
                    System.out.println(enemy.getEnemyName() + "is already dead");

            }
        }
    }*/
}

