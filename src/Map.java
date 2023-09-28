public class Map {
    private Room startingRoom;

    public Map(){
        Room room1 = new Room("Room1", "You are standing in a cave, you hear the water silently dripping from above. \n" +
                "You can see a dim light to one side of you, and hear water running in a distance. Which way would you like to go?");
        Room room2 = new Room("Room2", "You can see the remains of a fire and the embers glowing in the dark.\n" +
                " You discover footsteps going further in to the cave. Which way would you like to explore?");
        Room room3 = new Room("Room3", "You stop and see that you are standing on edge of a cliff, \n " +
                "and you need to cross a wooden bridge to get over to the other side. Would you like to go across or in another direction?");
        Room room4 = new Room("Room4", "You have followed the sound of water, and now you are standing on a riverbank.\n" +
                "You see a small boat floating around. The boat seems rather broken, would you like to try to get to the other side or explore another direction?");
        Room room5 = new Room("Room5", "You have entered a great cave with a big lake covered in shimmering light.\n " +
                "Three stones leads the way to the center of the lake, where you see a big chest with a big rusty lock on it. \n" +
                "Which way would like to go?");
        Room room6 = new Room("Room6", "You are now going down a small path, there is suspeciously quit. The path splits up in serveal directions\n"+
                "which way would you to go?");
        //Skal vi tilføje lyd?
        Room room7 = new Room("Room7", "You are now standing on the riverbank. Suddenly you notice a silent sound of drums. \n"+
                "The sound of the drums get louder and louder. You can't quite hear where the sound is comming from, which way would you like to go?");
        //DET STORE FARLIGE RUM!! :O :O :O :O
        Room room8 = new Room("Room8", "You feel a sudden heat, and starts to sweat. You look down and see lava floating \n"+
                "around you, dangerously close. There are stones floating around like an iced sea. Where would you like to go?");
        Room room9 = new Room("Room9", "You are now deep into the cave, you have to climb up a steep hill to go west. \n "+
                "Can you take the climp, or go in another direction?");


        //ITEMS FOR EACH ROOM
        Item item1 = new Item("Sword", "A sharp, shiny sword.");
        Item item2 = new Item("Key", "A rusty old key.");

        startingRoom = room1;

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


        // ADD ITEMS TO EACH ROOM
        room1.addItem(item1);
        room2.addItem(item2);

    }


    //Getter for startingroom
    public Room getStartingRoom() {
        return startingRoom;
    }

}
