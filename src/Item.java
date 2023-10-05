public class Item {
    private String name;
    private String description;


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
//    public String toString() {
//        return itemName + '\'' +
//                ", description -'" + description;
//    }
/*    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Item item : inventory) {
            builder.append(item.toString()).append(", ");
        }
        if (!inventory.isEmpty()){
            builder.setLength(builder.length()-2);
        }
        return builder.toString();
    }

    public String getIndexedSuperheroes(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Superhero IS : superheroes){
            stringBuilder.append(superheroes.indexOf(IS) + 1);
            stringBuilder.append(" ");
            stringBuilder.append(IS);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }*/

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }

}