public class Player {
    private Room currentRoom;
    private Room room;

    //Adventure adventure = new Adventure();
    Map map = new Map();



    //    public Player(Room startingRoom){
    //        this.currentRoom = startingRoom;
    //    }




    public void move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
            case "n":
                nextRoom = currentRoom.getNorth();
                break;
            case "east":
            case "e":
                nextRoom = currentRoom.getEast();
                break;
            case "west":
            case "w":
                nextRoom = currentRoom.getWest();
                break;
            case "south":
            case "s":
                nextRoom = currentRoom.getSouth();
                break;

        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
