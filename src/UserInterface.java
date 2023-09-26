import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startProgram() {

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("""
                ---------------------------------------|
                1. Type 'Help' to show instructions \s |
                2. Type 'Start' to start the game \s   |
                3. Type 'Exit' to exit the game        |
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

    public void help() {
        System.out.println("To start the game press Start");
        System.out.println("Congratulations you have started the game");
        System.out.println("Where do you want to go");
        System.out.println("To go on north press N");
        System.out.println("You cant go that way");
        System.out.println("Do you want to go east press E");
        System.out.println("Do you want to go south press S");
        System.out.println("Go to right press R");
        System.out.println("You made it to room 9 would you like to continue?");

    }

    private void move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
                nextRoom = adventure.currentRoom.getNorth();
                break;
            case "east":
                nextRoom = adventure.currentRoom.getEast();
                break;
            case "west":
                nextRoom = adventure.currentRoom.getWest();
                break;
            case "south":
                nextRoom = adventure.currentRoom.getSouth();
                break;

        }

        if (nextRoom != null) {
            adventure.currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public void startGame() {
        while (true) {
            //Display room information
            System.out.println("You are in " + adventure.currentRoom.getName());
            System.out.println(adventure.currentRoom.getDiscription());

            //Ask user for commands
            System.out.println("Enter a command: \n" +
                    "Type 'help' for help \n" +
                    "Type 'exit' to exit the game \n" +
                    "Type 'go... (direction) to move'");
            
            handleUserInput();
        }
    }
    
    private void handleUserInput() {

        String userInput = keyboard.nextLine().toLowerCase();

        switch (userInput) {
            case "look":
                userLook();
                break;
            case "help":
                help();
                break;
            case "exit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                //Check the users desired direction - n,s,w,e still doesn't work :(
                if (userInput.startsWith("go ")) {
                    String direction = userInput.substring(3);
                    move(direction);
                } else if (userInput.startsWith("n") || userInput.startsWith("w") || userInput.startsWith("e") || userInput.startsWith("s")) {
                    String direction = userInput;
                    move(direction);
                } else {
                    System.out.println("Invalid command");
                }
                break;
        }
    }
    private void userLook() {
        System.out.println(adventure.currentRoom.getDiscription());
    }
}
