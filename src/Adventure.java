import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    public Room currentRoom;


    public Adventure() {
    //Initialize rooms (names and descriptions) and connections
    //Indsæt det med at samle et kompas op
    Room room1 = new Room("Room1", "You are standing in a cave, you hear the water silently dripping from above. \n" +
            "You can see a dim light east of you, and hear water running to your south. Which way would you like to go?");
    Room room2 = new Room("Room2", "You can see the remains of a fire and the embers glowing in the dark.\n" +
            " You discover footsteps going further in to the cave. Would you like to go east or west?");
    Room room3 = new Room("Room3", "You stop and see that you are standing on edge of a cliff, \n " +
            "and you need to cross a wooden bridge to get over to the other side. Would you like to go west or south?");
    Room room4 = new Room("Room4", "You have followed the sound of water, and now you are standing on a riverbank.\n" +
            "You see a small boat floating around. Do you want to back north or continue further south?");
    Room room5 = new Room("Room5", "You have entered a great cave with a big lake covered in shimmering light.\n " +
            "Three stones leads the way to the center of the lake, where you see a big chest with a big rusty lock on it. \n" +
            "Would you like to go back south?");
    Room room6 = new Room("Room6", "");
    Room room7 = new Room("Room7", "ababababa");
    Room room8 = new Room("Room8", "ababababa");
    Room room9 = new Room("Room9", "ababababa");

    //setting the starting room
    currentRoom = room1;

    //set directions - followed the drawing
    //room1
    room1.setEast(room2);
    room1.setSouth(room4);

    //room2
    room2.setWest(room1);
    room2.setEast(room3);

    //room3
    room3.setSouth(room6);
    room3.setWest(room2);

    //room6
    room6.setNorth(room3);
    room6.setSouth(room9);

    //room9
    room9.setWest(room8);
    room9.setNorth(room6);

    //room8
    room8.setNorth(room5);
    room8.setEast(room9);
    room8.setWest(room7);

    //room7
    room7.setEast(room8);
    room7.setNorth(room4);

    //room4
    room4.setSouth(room7);
    room4.setNorth(room1);

    }
}
