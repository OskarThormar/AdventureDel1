import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;


    public UserInterface() {

        this.adventure = new Adventure();
    }

    public void startProgram() {
        String userSelection = "start";
        do {
            System.out.println("Welcome to the Adventure Game!");
            System.out.println("""
                    ---------------------------------------|
                    1. Type 'Help' to show instructions    |
                    2. Type 'Start' to start the game      |
                    3. Type 'Exit' to exit the game        |
                    ---------------------------------------|
                    """);

            System.out.println("Enter selection");
            userSelection = keyboard.nextLine();
            handleUserSelection();

                 /*   switch (userSelection.toLowerCase()) {
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

        }*/
        }
        while (!userSelection.toLowerCase().equals("Exit"));
    }

    public void startGame() {
        while (true) {
            // Display room information
            System.out.println("You are in " + adventure.currentRoom.getName());
            System.out.println(adventure.currentRoom.getDescription());

            // Ask user for commands
            System.out.println("Enter a command: \n" +
                    "Type 'look' to search the room \n" +
                    "Type 'go...' (direction) to move \n" +
                    "Type 'help' for help \n" +
                    "Type 'exit' to exit the game \n");

            handleUserSelection();
        }
    }

    private void handleUserSelection() {
        boolean gameRunning = true;

        while (gameRunning) {
            String[] userSelection = keyboard.nextLine().toLowerCase().trim().split(" ");
            String firstWord = userSelection[0];
            switch (firstWord) {
                case "look":
                    userLook();
                    break;
                case "start":
                    startGame();
                    break;
                case "help":
                case "info":
                    help();
                    break;
                case "quit":
                case "exit":
                case "bye":
                    gameRunning = false;
                    System.out.println("Thank you for playing Adventure Game! Come back another time :-)");
                    break;
                case "go":
                    String secondWord = userSelection[1];
                    adventure.move(secondWord);
                    break;
                default:
                    System.out.println("I don't understand");
            }
        }
    }

    private void userLook() {
        System.out.println(adventure.currentRoom.getDescription());
    }

    public void help() {
        // if { adventure.currentRoom = adventure.
        System.out.println("== Help Menu ==");
        System.out.println("Basic Needs:");
        System.out.println("- Water: Stay hydrated during your adventure.");
        System.out.println("- Light: Illuminate dark areas.");
        System.out.println("- First Aid Kit: Use it to heal injuries.");
        System.out.println("- Snack: Restore your energy.");

        System.out.println("Tools and Weapons:");
        System.out.println("- Sword: Use for close combat.");
        System.out.println("- Bow and Arrow: Attack enemies from a distance.");
        System.out.println("- Shield: Provides defense against enemy attacks.");

        System.out.println("Assistance:");
        System.out.println("- Elf for Dragon: Seek help from the Elf to battle the Dragon.");
        System.out.println("- Fairies: Call upon fairies for assistance.");
        System.out.println("- Summon Familiar: Summon a magical being to assist you.");
        System.out.println("- Healing Circle: Create a healing circle to restore health.");
        System.out.println("- Clairvoyance: See enemy positions or hidden paths.");
        System.out.println("- Summon Allies: Call upon allies to aid you in battle.");
        System.out.println("Magic Potion for Temporary Invisibility: Brew a potion for temporary invisibility");

        System.out.println("Navigation:");
        System.out.println("- N: Go North");
        System.out.println("- E: Go East");
        System.out.println("- S: Go South");
        System.out.println("- R: Go Right");

        System.out.println("Other Options:");
        System.out.println("- Do you need a ladder to get out from the dungeons?");
        System.out.println("- To proceed to Room 9, type 'continue'");
        System.out.println("- You can't go that way");

        System.out.println("Additional Features:");
        System.out.println("- Crafting and Resources: Gather resources and craft items.");
        // System.out.println("- Trade and Shops: Interact with traders to buy/sell items.");
        System.out.println("- Day/Night Cycle: Experience different challenges based on time.");
        System.out.println("- Weather Conditions: Encounter different weather affecting gameplay.");
        System.out.println("- Skills and Abilities: Improve your skills and abilities as you progress.");
        System.out.println("- Wildlife Interaction: Encounter and interact with various wildlife.");
    }
}
