public class Map {
    private Room startingRoom;

    public Map(){
        Room room1 = new Room(" ", "You are standing in a cave, you hear the water silently dripping from above. \n" +
                "You can see a dim light to one side of you, and hear water running in a distance. Which way would you like to go?");
        Item food1Room1 = new Food("apple", "extremely delicious", 20);
        room1.addItem(food1Room1);

        Room room2 = new Room(" ", "You can see the remains of a fire and the embers glowing in the dark.\n" +
                " You discover footsteps going further in to the cave. Which way would you like to explore?");
        Item item1Room2 = new Item("Sword", "A sharp, shiny sword.");
        room2.addItem(item1Room2);

        Room room3 = new Room(" ", "You stop and see that you are standing on edge of a cliff, \n " +
                "and you need to cross a wooden bridge to get over to the other side. Would you like to go across or in another direction?");
        Item food2Room3 = new Food("Mushroom", "funky looking", -40);
        //Item or food?
        Room room4 = new Room(" ", "You have followed the sound of water, and now you are standing on a riverbank.\n" +
                "You see a small boat floating around. The boat seems rather broken, would you like to try to get to the other side or explore another direction?");
        Item item2Room4 = new Item("paddle", "an old rotten paddle.");
        Item food3Room4= new Food("seaweed", "tasty", 1);

        Room room5 = new Room(" ", "You have entered a great cave with a big lake covered in shimmering light.\n " +
                "Three stones leads the way to the center of the lake, where you see a big chest with a big rusty lock on it. \n" +
                "Which way would like to go?");
        Item food4Room5 = new Food("bær", "Blå glimtende ", -80);


        Room room6 = new Room(" ", "You are now going down a small path, there is suspeciously quit. The darkness is overwhelming you can't see\n" +
                " see anything, and you feel your way through the darkness. You suddenly feel a wooden box, and it seems like the path splits up in serveal directions\n"+
                "which way would you to go?");
            Item item3Room6 = new Item("Key", "A rusty old key.");
            room6.addItem(item3Room6);

        Room room7 = new Room(" ", "You are now standing on the riverbank. Suddenly you notice a silent sound of drums. \n"+
                "The sound of the drums get louder and louder. You can't quite hear where the sound is comming from. Nearby in the river something is floating around. \n" +
                "Which way would you like to go?");
        // Shield?
        //a freaking looking cake?

        //DET STORE FARLIGE RUM!! :O :O :O :O
        Room room8 = new Room(" ", "You feel a sudden heat, and starts to sweat. You look down and see lava floating \n"+
                "around you, dangerously close. There are stones floating around like an iced sea. Where would you like to go?");
        //
        Room room9 = new Room(" ", "You are now deep into the cave, you have to climb up a steep hill to go west. \n "+
                "Can you take the climp, or go in another direction?");
        //Adventurous booots


        //ITEMS FOR EACH ROOM



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


    }


    //Getter for startingroom
    public Room getStartingRoom() {
        return startingRoom;
    }

}
