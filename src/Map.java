public class Map {
    private Room startingRoom;

    public Map(){
        Room room1 = new Room(" ", "You are standing in a cave, you hear the water dripping from above. \n" +
                "You can see a dim light to one side of you, and hear water running in a distance. Which way would you like to go?");
        Item apple = new Food("Apple", "Edible and nutritious  \uD83C\uDF4E",  20);
        room1.addItem(apple);

        Room room2 = new Room(" ", "You can see the remains of a fire and the embers glowing in the dark.\n" +
                " There are footsteps going further in to the cave. Which way would you like to explore?");
        Item Bow = new RangedWeapon("Bow", " Looks Elvish  \uD83C\uDFF9", 2, "Ranged", 0);
        room2.addItem(Bow);
        Item Arrow1 = new RangedWeaponAmmo("Arrows", "Bundle of arrows", 0, "Arrows", 20);
        room2.addItem(Arrow1);

        Room room3 = new Room(" ", "You stop and see that you are standing on edge of a cliff,\n" +
                "and you need to cross a wooden bridge to get over to the other side. Would you like to go across or in another direction?\n "
                + "\uD83D\uDCA5 WAAAUUUUUGHH!!!! \uD83D\uDCA5 \n" + "There's an enemy in the room! \uD83D\uDE31");
        Item mushroom = new Food("Mushroom", " Very funky looking \uD83C\uDF44", -40);
        room3.addItem(mushroom);
        Enemy goblinRoom3 = new Enemy("Goblin", " small but aggressive \uD83D\uDC7F", 20, 3);
        Item goblinDagger = new MeleeWeapon("Goblin dagger", "Greasy and disgusting, looks dull", 5, "Melee");
        room3.addEnemy(goblinRoom3);
        goblinRoom3.addEnemyItems(goblinDagger);

        Room room4 = new Room(" ", "You have followed the sound of water, and now you are standing on a riverbank.\n" +
                "You see a small boat floating around. The boat seems rather broken, would you like to try to get to the other side or explore another direction?");
        Item paddle = new MeleeWeapon("Paddle", ", looks old and rotten.", 3, "Melee");
        room4.addItem(paddle);
        Item seaweed= new Food("Seaweed", "Can be tasty \uD83C\uDF3F", 1);
        room4.addItem(seaweed);

        Room room5 = new Room(" ", "You have entered a great cave with a big lake covered in shimmering light.\n " +
                "Three stones leads the way to the center of the lake, where you see a big chest with a big rusty lock on it. \n" +
                "Which way would like to go?");
        Item berries = new Food("Berries", " Blue and maybe fresh  \uD83C\uDF47", -80);
        room5.addItem(berries);

        Room room6 = new Room(" ", "You are now going down a small path, there is suspeciously quiet. The darkness is overwhelming you can't see\n" +
                " see anything, and you feel your way through the darkness. \n" +
                "You suddenly feel a wooden box, and it seems like the path splits up in serveral directions\n"+
                "which way would you to go? \n");
        Item arrow2 = new RangedWeaponAmmo(" arrow", " old, but maybe still working \uD83D\uDC81\u200D♂\uFE0F", 1, "arrow", 1);
        Enemy ghostRoom6 = new Enemy("Nightshade ghost", " a dark shadow ", 30, 5);
        Item key = new Item("Key", "A rusty old key.  \uD83D\uDDDD\uFE0F");
            room6.addEnemy(ghostRoom6);
            ghostRoom6.addEnemyItems(key);

        Room room7 = new Room(" ", "You are now standing on the riverbank. Suddenly you notice a silent sound of drums. \n"+
                "The sound of the drums get louder and louder \uD83D\uDE28. You can't quite hear where the sound is comming from. Nearby in the river something is floating around. \n" +
                "Which way would you like to go?");
        Enemy WaterSpiritRoom7 = new Enemy("Water Spirit ", " glowing enchantingly in blue tones \uD83E\uDDDE\u200D♀\uFE0F", 10, 2);
        room7.addEnemy(WaterSpiritRoom7);
        Item water = new Food("Bottle of water ", "Magical crystal and crystal clear \uD83D\uDCA7", 10);
        Item Sword = new MeleeWeapon("Sword", "Appears sharp and shiny \uD83D\uDDE1\uFE0F", 4, "Melee");
        room7.addItem(Sword);
        room7.addItem(water);

        Room room8 = new Room(" ", "You feel a sudden heat, and starts to sweat. You look down and see lava floating \n"+
                "around you, dangerously close. There are stones floating around in the lava. Where would you like to go?");
        Item beer = new Food("Beer ", "Refreshing and very much needed  \uD83C\uDF7A", 20);
        Enemy lavamonster = new Enemy("Lava Monster", "A giant creature made of burning lava that blazes with intense heat", 80, 20);
        room8.addEnemy(lavamonster);
        room8.addItem(beer);

        Room room9 = new Room(" ", "You are now deep into the cave, you have to climb up a steep hill to go west. \n "+
                "The hillside is entirely covered in vines, and nestled among the leaves, you see the most beautiful flower. \n " +
                "Can you take the climp, or go in another direction?");
        Item boots = new Item("Boots", " With an exceptional grip \uD83E\uDD7E");
        Item flower = new Food("Flower", "No color can describe this flower ", 5);
        room9.addItem(flower);
        room9.addItem(boots);


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
