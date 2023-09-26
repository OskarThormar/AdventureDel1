import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    public Room currentRoom;


public Adventure() {
    //Initialize rooms (names and descriptions) and connections
    //Indsæt det med at samle et kompas op
    Rooms room1 = new Rooms("Room1", "You are standing in a cave, you hear the water silently dripping from above. \n" +
            "You can see a dim light east of you, and hear water running to your south. Which way would you like to go?");
    Rooms room2 = new Rooms("Room2", "You can see the remains of a fire and the embers glowing in the dark.\n" +
            " You discover footsteps going further in to the cave. Would you like to go east or west?");
    Rooms room3 = new Rooms("Room3", "");
    Rooms room4 = new Rooms("Room4", "ababababa");
    Rooms room5 = new Rooms("Room5", "ababababa");
    Rooms room6 = new Rooms("Room6", "ababababa");
    Rooms room7 = new Rooms("Room7", "ababababa");
    Rooms room8 = new Rooms("Room8", "ababababa");
    Rooms room9 = new Rooms("Room9", "ababababa");

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
