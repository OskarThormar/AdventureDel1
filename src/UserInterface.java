import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    public void startProgram() {

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("""
            ---------------------------------------|
            1. Type 'help' to show instructions \s |
            2. Type 'Start' to start the game \s   |
            3. Type 'Exit' to exit the game        |
            ---------------------------------------|
            """);

        String userSelection = keyboard.nextLine();

        switch (userSelection.toLowerCase()) {
            case "help":
                help();
            case "start":
                break;
            case "exit":
                break;
            default:
                System.out.println("Choose an option from above");
                break;
        }
    }
    private void help(){
        System.out.println("help, bla bla");
    }
}
