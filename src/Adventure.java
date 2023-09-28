public class Adventure {
    private Player player;
    private Map map;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartingRoom());

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
}
