public class Item {
    protected String name;
    protected String indexName;
    protected String description;


    public Item(String name, String indexName, String description) {
        this.name = name;
        this.indexName = indexName;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getIndexName(){
        return indexName;
    }

    public String getDescription() {
        return description;
    }
    public String getCurrentWeaponType(){
        return null;
    }
    public int getCurrentWeaponDamage(){
        return 0;
    }
    @Override
    public String toString() {
        return name + " " + description;
    }

    public void setCurrentWeapon() {

    }

}