public class Adventure {
    private Player player;
    private Map map;

    public Adventure() {
        this.map = new Map();
        //set the player maximum inventory to 5
        this.player = new Player(map.getStartingRoom(), 5);

        initializeGame();
    }

    //sets the players initial starting room
    public void initializeGame() {
        player.setCurrentRoom(map.getStartingRoom());
    }

    public void move(String direction){
        this.player.move(direction);
    }

    //retrieves the currentroom of the player
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    //Allow classes to access player
    public Player getPlayer() {
        return player;
    }
}
