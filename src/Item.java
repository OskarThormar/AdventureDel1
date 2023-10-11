public class Item {
    protected String name;
    protected String description;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return name + " " + description;
    }

    public void setCurrentWeapon() {

    }

}