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
                   adventure.start();
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
       }
    private void help(){
        System.out.println("help, bla bla");
    }
}
