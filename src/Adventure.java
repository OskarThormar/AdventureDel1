public class Adventure {
    public Room currentRoom;
    private Player player;

    public Adventure() {
        this.player = new Player();
    }

    //public Adventure(Room startingRoom) {
    //    this.player = new Player(startingRoom);
    //}

    public void move(String direction){
        this.player.move(direction);
    }


    public Room currentRoom() {
        return player.getCurrentRoom();
    }

}
