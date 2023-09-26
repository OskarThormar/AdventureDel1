import javax.management.BadAttributeValueExpException;
import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        adventure = new Adventure();
    }

    public void startProgram() {

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("""
            ---------------------------------------|
            1. Type 'Help' to show instructions \s  |
            2. Type 'Start' to start the game \s    |
            3. Type 'Exit' to exit the game        |
            ---------------------------------------|
            """);

        //while loop so the game keeps running until the player decides to exit
       while (true) {
           String userSelection = keyboard.nextLine();

           switch (userSelection.toLowerCase()) {
               case "help":
                   help();
               case "start":
                   //adventure.start();
                   //while loop so the game keeps running until the player decides to exit
                   while (true) {
                       //Display room information
                       System.out.println("You are in " + adventure.currentRoom.getName());
                       System.out.println(adventure.currentRoom.getDiscription());

                       //Ask user for commands
                       System.out.println("Enter a command: \n" +
                               "Type 'help' for help \n" +
                               "Type 'exit' to exit the game \n" +
                               "Type 'go... (direction) to move'" );
                       String userInput = keyboard.nextLine().toLowerCase();

                       switch (userInput) {
                           case "look":
                               System.out.println(adventure.currentRoom.getDiscription());
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
                                   adventure.move(direction);
                               } else if (userInput.startsWith("n") || userInput.startsWith("w") || userInput.startsWith("e") || userInput.startsWith("s")) {
                                   String direction = userInput;
                                   adventure.move(direction);
                               } else {
                                   System.out.println("Invalid command");
                               }
                               break;
                       }
                   }
               case "exit":
                   System.out.println("Have a great day");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Choose an option from above");
                   break;
           }
       }
    }
    public void help(){
        System.out.println("help, bla bla");
    }
}
