public class Rooms {
    private String name;
    private String discription;
    private Rooms north;
    private Rooms east;
    private Rooms south;
    private Rooms west;

    public Rooms(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Rooms getNorth() {
        return north;
    }

    public void setNorth(Rooms north) {
        this.north = north;
    }

    public Rooms getEast() {
        return east;
    }

    public void setEast(Rooms east) {
        this.east = east;
    }

    public Rooms getSouth() {
        return south;
    }

    public void setSouth(Rooms south) {
        this.south = south;
    }

    public Rooms getWest() {
        return west;
    }

    public void setWest(Rooms west) {
        this.west = west;
    }
}
